package Threads.ConditionDemo;

import java.util.concurrent.locks.ReentrantLock;

public class ReEntrantLockDemo {
	
	private final ReentrantLock lock = new ReentrantLock();
	private int sharedData = 0;
	
	public void methodA()
	{
		lock.lock();
		try
		{
			sharedData++;
			System.out.println("Method A shared data: "+sharedData);
			methodB();
		}
		finally
		{
			lock.unlock();
		}
	}

	private void methodB() {
		lock.lock();
		// TODO Auto-generated method stub
		try
		{
			sharedData--;
			System.out.println("Method A shared data: "+sharedData);
			
		}
		finally
		{
			lock.unlock();
		
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReEntrantLockDemo demo = new ReEntrantLockDemo();
		
		for(int i=0 ;i<5;i++)
		{
			new Thread(demo::methodA).start();
		}

	}

}
