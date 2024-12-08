package Threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ThreadReturnValue {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		// TODO Auto-generated method stub
	    ExecutorService executorService = Executors.newFixedThreadPool(2);
		try
		{

		Future<Integer> result=	executorService.submit(new ReturnValueTask());
		System.out.println(result.get(6, TimeUnit.SECONDS));
		//Important methods
		boolean cancelled = result.isCancelled();
		boolean isdone = result.isDone();
		System.out.println("Cancelled? "+cancelled+" Is Done? "+isdone);
		}
		finally
		{ 
			executorService.shutdown(); 
			if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) 
			{ 
				executorService.shutdownNow();
			}
			System.out.println("Main thread execution complete");

		}
		

	}

}

class ReturnValueTask implements Callable<Integer>
{

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(5000);
		return 12;
	}
	
}