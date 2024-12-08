package Threads.ConditionDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService service = Executors.newCachedThreadPool();
		try
		{
			for(int i=0;i<15;i++)
			{
			service.execute(new Runnable() {
				@Override
				public void run()
				{
					ScrapeService.INSTANCE.scrape();
				}
			});
			}
		}
		finally
		{
		  service.shutdown();
		 
		}

	}

}

enum ScrapeService
{
	INSTANCE;
	
	private Semaphore semaphore = new Semaphore(1);
	
	public void scrape()
	{
		try
		{
			semaphore.acquire();
			invokeScrapeBot();
		}
		catch(InterruptedException e)
		{
			throw new RuntimeException(e);
		}
		finally
		{
			semaphore.release();
		}
		
	}

	private void invokeScrapeBot() throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Scraping data");
		Thread.sleep(2000);
		
	}
	
}
