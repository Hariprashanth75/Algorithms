package Threads;

public class DaemonThreads {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread t1 = new Thread(new BackgroundThread());
		Thread t2 = new Thread(new UserThread());
		
		t1.setDaemon(true);
		t1.start();
		t2.start();

	}
	
	
	

}
//Deamon thread terminates irrespective of whether it completes execution or not if main or other threads are done
class BackgroundThread implements Runnable
{
    
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int count = 0;
		while(count < 500) {
		try {
			Thread.sleep(1000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		count++;
		System.out.println("Daemon thread is executing...");
		}
		
		
	}
	
}

class UserThread implements Runnable
{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(5000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("User thread is executing...");
		
	}
	
}
