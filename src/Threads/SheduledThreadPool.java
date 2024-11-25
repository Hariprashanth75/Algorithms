package Threads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SheduledThreadPool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		executor.scheduleAtFixedRate(new WorkThread(), 1000, 2000, TimeUnit.MILLISECONDS);
		
		try
		{
			if(!executor.awaitTermination(10000, TimeUnit.MILLISECONDS))
			{
				executor.shutdownNow();
			}
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
			executor.shutdownNow();
		}

	}

}
class WorkThread implements Runnable
{


	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Probing for endpoints");

	}
	
}
