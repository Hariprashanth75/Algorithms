package Threads.ConditionDemo;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class ForkJoinPoolDemo 
{
	public static class FJP extends RecursiveTask<Integer> {
		
		int[] arr;
		int start;
		int end;
		int searchElement;
		

		
		public FJP(int[] arr, int start, int end, int searchElement) {
			super();
			this.arr = arr;
			this.start = start;
			this.end = end;
			this.searchElement = searchElement;
		}

		

		@Override
		protected Integer compute() {
			// TODO Auto-generated method stub
			int size= end-start+1;
			if(size > 50)
			{
				int mid = (start+end)/2;
				FJP task1 = new FJP(arr, start, mid, searchElement);
				FJP task2 = new FJP(arr, mid+1, end, searchElement);
				
				task1.fork();
				task2.fork();
				
				return task1.join() + task2.join();
				
				
			}
			else
			{
			return search();
			}
		}

		private Integer search() {
			// TODO Auto-generated method stub
			int count=0;
			for(int i=start ; i< end ; i++)
			{
				if(arr[i] == searchElement)
				{
					count++;
				}
			}
			return count;
		}

	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= new int[100];
		Random random = new Random();
		for(int i= 0;i< arr.length;i++)
		{
			arr[i] = random.nextInt(10)+1;
		}
		
		int searchElement = random.nextInt(10)+1;
		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		try
		{	
		
		FJP task = new FJP(arr, 0, arr.length, searchElement);
		Integer occurrence =pool.invoke(task);
		System.out.println("Array is: "+Arrays.toString(arr));
		System.out.printf("%d found %d time", searchElement, occurrence);
		}
		finally
		{
			pool.shutdown();
		}
		

	}
}

