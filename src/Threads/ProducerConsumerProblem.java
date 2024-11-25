package Threads;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerProblem {
	
	public static void main(String[] args)
	{
		
		Worker worker = new Worker(5,0);
		
		Thread producer = new Thread(()->{
			
			try {
				worker.produce();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		});
		
		Thread consumer = new Thread(()->{
			
			try {
				worker.consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		});
		producer.start();
		consumer.start();
		
	}
}
	
	class Worker
	{
		private int sequence=0;
		private final Integer top;
		private final Integer bottom;
		private final List<Integer> container;
		private final Object lock = new Object();
		
		
		public Worker(Integer top, Integer bottom) {
			super();
			
			this.top = top;
			this.bottom = bottom;
			this.container = new ArrayList<>();
		}

		public void produce() throws InterruptedException
		{
			synchronized(lock)
			{
				while(true)
				{
					if(container.size()== top)
					{
						System.out.println("Container is full, waiting for items to be removed");
						lock.wait();
					}
					else
					{
						System.out.println("Sequence added to the container" + sequence);
						container.add(sequence++);
						lock.notify();
					}
					Thread.sleep(500);
				}
				
			}
			
		}
		
		public void consume() throws InterruptedException
		{
			synchronized(lock)
			{
			while(true)
			{
				if(container.size()== bottom)
				{
					System.out.println("The container is empty, waiting for items to be added");
					lock.wait();
				}
				else
				{
					System.out.println(container.remove(0) + "removed from container");
					lock.notify();
				}
				Thread.sleep(500);
				
			}
			
			}
			
		}
		
	}



