package Threads;

public class ThreadPriority {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName());
//		System.out.println(Thread.currentThread().getPriority());
//		Thread.currentThread().setPriority(Thread.NORM_PRIORITY);
//		System.out.println(Thread.currentThread().getPriority());
		
		Thread t1 = new Thread( ()-> {
			System.out.println("Thread 1 is running");
		});
		
		t1.setPriority(Thread.MAX_PRIORITY);
		t1.start();

	}

}
