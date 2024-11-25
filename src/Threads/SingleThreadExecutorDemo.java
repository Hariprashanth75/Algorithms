package Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService service = Executors.newSingleThreadExecutor();
		try
		{
			for(int i=0; i<=5; i++)
			{
				service.execute(new Task(i));
			}
		}
		finally
		{
			service.shutdown();
		}
		
		ExecutorService service2 = Executors.newSingleThreadExecutor();
		try
		{
			for(int i=0; i<=5; i++)
			{
				service2.execute(new Task(i));
			}
		}
		finally
		{
			service2.shutdown();
		}

	}

}

class Task implements Runnable {
	
	private int taskID = 0;
	
	public Task(int taskID)
	{
		this.taskID = taskID;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("The task with taskID: "+taskID+" is running by"+Thread.currentThread().getName());
		
		try
		{
			Thread.sleep(500);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
	}
	
}