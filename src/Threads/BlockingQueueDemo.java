package Threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {

	static final int QUEUE_CAPACITY= 10;
	static BlockingQueue<Integer> taskQueue= new ArrayBlockingQueue<>(QUEUE_CAPACITY);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Producer thread
		Thread producer = new Thread(() -> {
			try
			{
				for(int i=0;i<20;i++)
				{
					taskQueue.put(i);
					System.out.println("Task produced "+i);
					Thread.sleep(100);
				}
				
			}
			catch(InterruptedException e)
			{
				throw new RuntimeException(e);
			}
		});
		
		Thread ConsumerOne = new Thread(() -> {
			try
			{
				while(true)
				{
					int task = taskQueue.take();
					processTask(task, "ConsumerOne");
					
					
				}
				
			}
			catch(InterruptedException e)
			{
				throw new RuntimeException(e);
			}
		});
		
		Thread ConsumerTwo = new Thread(() -> {
			try
			{
				while(true)
				{
					int task = taskQueue.take();
					processTask(task, "ConsumerTwo");
					
					
				}
				
			}
			catch(InterruptedException e)
			{
				throw new RuntimeException(e);
			}
		});
		
		producer.start();
		ConsumerOne.start();
		ConsumerTwo.start();
		
	}

	private static void processTask(int task, String consumerName)throws InterruptedException {
		
		// TODO Auto-generated method stub
		System.out.println("The task being processed by " +consumerName+ " and task "+task );
		Thread.sleep(1000);
		System.out.println("The task consumed by " +consumerName+ " and task "+task );
	}

}
