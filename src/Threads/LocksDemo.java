package Threads;

public class LocksDemo {
	
	private static int count1=0;
	private static int count2=0;
	private static Object lock1= new Object();
	private static Object lock2 = new Object();
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread t1 = new Thread(() -> {
			for(int i=0 ; i<=10000 ; i++)
			{
				counter1();
			}
		});
		
		Thread t2 = new Thread(() -> {
			for(int i=0 ; i<=10000 ; i++)
			{
				counter2();
			}
		});
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(count1 + "---" + count2);
		

	}


	private static void counter2() {
		// TODO Auto-generated method stub
		synchronized(lock1)
		{
		count1++;
		}
		
	}


	//Lock is used for decoupling to seperate concerns on threads
	private static void counter1() {
		// TODO Auto-generated method stub
		synchronized(lock2)
		{
		count2++;
		}
		
	}

}
