package Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executor = Executors.newCachedThreadPool();
		
		try
		{
			for(int i=0; i<=1000;i++)
			{
				executor.execute(new WorkerCache(i));
			}
		}
		finally
		{
			executor.shutdown();
		}
		

	}

}

class WorkerCache implements Runnable
{

	private int taskID=0;
	
	public WorkerCache(int taskID) {
		super();
		this.taskID = taskID;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Task ID" + taskID + " is executed by "+ Thread.currentThread().getName());
		
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