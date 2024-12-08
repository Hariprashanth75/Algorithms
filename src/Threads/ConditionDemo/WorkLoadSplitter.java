package Threads.ConditionDemo;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class WorkLoadSplitter extends RecursiveAction{

	private final long workload;
	
	public WorkLoadSplitter(long workload) {
		super();
		this.workload = workload;
	}

	@Override
	protected void compute() {
		// TODO Auto-generated method stub
		if(workload > 16)
		{
			System.out.println("Work load too big! thus splitting: "+workload);
			long firstWorkload = workload/2;
			long secondWorkload = workload - firstWorkload;
			
			WorkLoadSplitter firstSplit = new WorkLoadSplitter(firstWorkload);
			WorkLoadSplitter secondSplit = new WorkLoadSplitter(secondWorkload);
			
			firstSplit.fork();
			secondSplit.fork();
			
			
		}
		else
		{
			System.out.println("Workload is within limits! Task being executed for the workload"+workload);
		}
		
	}
	
	 

}
class WorkLoadSplitDemo 
{
	public static void main(String[] args)
	{
		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		try
		{
			WorkLoadSplitter splitter = new WorkLoadSplitter(128);
			pool.invoke(splitter);
			
		}
	}
}