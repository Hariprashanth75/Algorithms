package Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService service = Executors.newFixedThreadPool(2);
		
		try
		{
			for(int i=0 ; i<=7 ; i++)
			{
				service.execute(new Work(i));
			}
		}
		finally
		{
			service.shutdown();
		}

	}

}

class Work implements Runnable
{

	private int taskID=0;
	
	public Work(int taskID) {
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
