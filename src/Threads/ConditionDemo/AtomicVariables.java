package Threads.ConditionDemo;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariables {
	private static int count=0;
	private static final AtomicInteger counter = new AtomicInteger(0);
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(()-> {
			for(int i=0;i<10000;i++)
			{
				//count++;
				counter.incrementAndGet();
			}
		});
		
		Thread t2 = new Thread(() -> {
			for(int i=0;i<10000;i++)
			{
				counter.incrementAndGet();
			}
		});
		
		t1.start();
		t2.start();
		
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Count value "+counter);
		

	}

}
