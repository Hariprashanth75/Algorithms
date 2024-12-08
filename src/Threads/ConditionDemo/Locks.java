package Threads.ConditionDemo;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class Locks {
	private Integer MAX_SIZE=5;
	private final Lock lock =new ReentrantLock();
	private final Queue<Integer> buffer = new LinkedList<>();
	private final Condition bufferNotFull = lock.newCondition();
	private final Condition bufferNotEmpty = lock.newCondition();
	
	public void produce(int item) throws InterruptedException
	{
		lock.lock();
		try
		{
			while(buffer.size() == MAX_SIZE)
			{
				bufferNotFull.await();
			}
			buffer.offer(item);
			System.out.println("Produced >> "+item);
			bufferNotEmpty.signal();
		}
		finally
		{
			lock.unlock();
		}
	}
	
	private void consume() throws InterruptedException
	{
		lock.lock();
		
		try
		{
			while(buffer.isEmpty())
			{
				bufferNotEmpty.await();
			}
			System.out.println("Consumed << "+ buffer.poll());
			bufferNotFull.signal();
		}
		finally
		{
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locks demo = new Locks();
		
		Thread producer = new Thread ( () -> {
			try
			{
				for(int i=0;i<10;i++)
				{
					demo.produce(i);
					Thread.sleep(1000);
				}
				
			}
			catch(InterruptedException e)
			{
				throw new RuntimeException(e);
			}
		});
		
		Thread consumer = new Thread(()-> {
			try
			{
				for(int i=0;i<10;i++)
				{
					demo.consume();
					Thread.sleep(2000);
				}
			}
			catch(InterruptedException e)
			{
				throw new RuntimeException(e);
			}
		});
		
		producer.start();
		consumer.start();

	}

}