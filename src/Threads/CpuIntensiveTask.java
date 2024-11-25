package Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CpuIntensiveTask {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cores = Runtime.getRuntime().availableProcessors();
		ExecutorService service = Executors.newFixedThreadPool(cores);
		System.out.println("Created thread pool with :" +cores+ " cores");
		
		for(int i=0; i<=20 ; i++)
		{
			service.execute(new TaskCPU());
		}

	}

}

class TaskCPU implements Runnable
{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Some CPU intensive task is run by:"+Thread.currentThread().getName());
		
	}
	
}
