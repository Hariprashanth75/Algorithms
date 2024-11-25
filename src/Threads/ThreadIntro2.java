package Threads;

public class ThreadIntro2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread t1 = new Thread1();
		Thread t2 = new Thread2();
		
		t1.start();
		t2.start();

	}

}

class Thread1 extends Thread
{
	@Override
	public void run()
	{
		for(int i =0 ; i<=5 ; i++)
		{
			System.out.println("Thread 1: "+i);
		}
	}
}

class Thread2 extends Thread
{
	@Override
	public void run()
	{
		for(int i =0 ; i<=5 ; i++)
		{
			System.out.println("Thread 2: "+i);
		}
	}
}
