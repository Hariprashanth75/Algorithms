package Threads;

import java.util.concurrent.CountDownLatch;

public class ConcurrentCollection {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int numberOfChefs =3;
		CountDownLatch latch = new CountDownLatch(numberOfChefs);
		new Thread(new Chef("Chef A","Pizza",latch)).start();
		new Thread(new Chef("Chef B","Pasta",latch)).start();
		new Thread(new Chef("Chef C","Salad",latch)).start();
		
		latch.await();
		System.out.println("All the dishes are reading, start serving!");
		

	}

}

class Chef implements Runnable
{
	private final String name;
	private final String dish;
	private final CountDownLatch latch;

	public Chef(String name, String dish, CountDownLatch latch) {
		super();
		this.name = name;
		this.dish = dish;
		this.latch = latch;
	}

	@Override
	public void run() {
		
		try
		{
		System.out.println("The chef "+name+" is preparing " +dish);
		Thread.sleep(500);
		System.out.println("The chef "+name+" has prepared " +dish);
		latch.countDown();
		}
		catch(InterruptedException e)
		{
		throw new RuntimeException(e);	
		}
		
	}
	
}
