package Threads;

public class ThreadIntro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new ThreadOne());
		Thread t2 = new Thread(new ThreadTwo());
		//Anonymous thread
		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0 ; i<=5 ; i++)
				{
				System.out.println("Thread 3: "+ i);
				}
				
			}
			
		});
		//Anonymous thread using lambda
		Thread t4 = new Thread( () -> {
			for(int i=0; i<=5 ; i++)
			{
				System.out.println("Thread 4: "+i);
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}
	

}

class ThreadOne implements Runnable
{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0 ; i<= 5 ; i++)
		{
			System.out.println("Thread 1 : " + i);		}
		
	}
	
}

class ThreadTwo implements Runnable
{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0 ; i<= 5 ; i++)
		{
			System.out.println("Thread 2 : " + i);		}
		
	}
	
}
