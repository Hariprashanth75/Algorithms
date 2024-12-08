package Threads;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Simulation simulation = new Simulation();
		simulation.simulate();

	}

}

class ReadTask implements Runnable {
	private final List<Integer> list;

	
	public ReadTask(List<Integer> list) {
		super();
		this.list = list;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(list);
		}
		
	}
	
}

class WriteTask implements Runnable
{
	private List<Integer> list;
	private Random random;
	

	public WriteTask(List<Integer> list) {
		super();
		this.list = list;
		this.random = new Random();
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list.set(random.nextInt(list.size()), random.nextInt(10));
			System.out.println(list);
		}
		
	}
	
}

class Simulation
{
	private final List<Integer> list;

	public Simulation() {
		super();
		this.list = new CopyOnWriteArrayList<>();
		this.list.addAll(Arrays.asList(0,0,0,0,0,0,0,0,0));
	}
	
	
	public void simulate()
	{
		Thread one = new Thread(new WriteTask(list));
		Thread two = new Thread(new WriteTask(list));
		Thread three = new Thread(new ReadTask(list));
		Thread four = new Thread(new ReadTask(list));
		
		one.start();
		two.start();
		three.start();
		four.start();
		
		
	}
}