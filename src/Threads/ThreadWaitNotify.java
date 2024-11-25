package Threads;

public class ThreadWaitNotify {

	private static Object lock = new Object();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread t1 = new Thread( ()-> {
			
			try {
				One();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
		
		Thread t2 = new Thread( ()-> {
			
			try {
				Two();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
		
		t1.start();
		t2.start();
		

	}
	//Wait is used for interthread communication and sleep will simply pause the execution
	//Lock will be aquired by next thread if we call wait and then previous thread will execute after notify is called
	
	private static void One() throws InterruptedException {
		synchronized(lock)
		{
			System.out.println("Hello from method 1");
			lock.wait();
			System.out.println("Back again from method 1");
		}
	}
	
	private static void Two() throws InterruptedException {
		synchronized(lock)
		{
			System.out.println("Hello from method 2");
			lock.notify();
			System.out.println("Back again from method 2");
		}
	}

}
