package Threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MultiStageTour {
	
	public static final int NUM_TOURISTS=5;
	public static final int NUM_STAGES=3;
	private static final CyclicBarrier barrier = new CyclicBarrier(NUM_TOURISTS, () -> {
		System.out.println("Tour guide starts speaking..");
	});
	
	static class Tourist implements Runnable
	{
		private final int touristId;
		
		

		public Tourist(int touristId) {
			super();
			this.touristId = touristId;
		}



		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=0;i<NUM_STAGES;i++)
			{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Tourist "+touristId+" arrives at " +(i+1));
				
				try {
					barrier.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					// TODO Auto-generated catch block
					throw new RuntimeException(e);
				}
			}
			
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i=0; i< NUM_TOURISTS; i++)
		{
			Thread touristThread = new Thread(new Tourist(i));
			touristThread.start();
		}

	}

}
