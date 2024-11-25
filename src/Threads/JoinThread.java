package Threads;

public class JoinThread {

	public static void main(String[] args) throws InterruptedException {
		
		// TODO Auto-generated method stub
		
		Thread t1 = new Thread( () -> {
			
			for(int i=0 ; i<=5 ; i++)
			{
				System.out.println("Thread 1: "+i);
			}
			
		});
		
		Thread t2 = new Thread( () -> {
			
			for(int i=0 ; i<=25 ; i++)
			{
				System.out.println("Thread 2: "+i);
			}
			
		});
		
		//Main thread is the only thread in context and even after thread.start() it goes to runnable state
		//Hence if we use join we can say after thread 1 executes, give priority to main thread
		System.out.println("Threads starting execution");
		t1.start();
		t2.start();
		t1.join();
		//t2.join();
		System.out.println("Main thread executed successfully");

	}

}
