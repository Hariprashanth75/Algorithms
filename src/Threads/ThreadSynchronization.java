package Threads;

public class ThreadSynchronization {

	private static int count=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread t1 = new Thread(() -> {
			for(int i=0;i<=10000;i++)
			{
				increment();
			}
		});
		
		Thread t2 = new Thread(() -> {
			for(int i=0;i<=10000;i++)
			{
				increment();
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
		
    System.out.println("The counter value: "+count);

	}
//Hey JVM ensure only one thread executes this block completely before other thread takes over
	private synchronized static void increment() {
		// TODO Auto-generated method stub
		count++;
		
	}
	

}
