package Threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedCollection {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//List<Integer> list = new ArrayList<>();
		List<Integer> list = Collections.synchronizedList(new ArrayList<>());
		
		Thread t1 = new Thread( () -> {
			for(int i=0 ;i<1000;i++)
			{
				list.add(i);
				
			}
		});
		
		Thread t2 = new Thread(() -> {
			for(int i=0; i<1000; i++)
			{
				list.add(i);
			}
		});
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		System.out.println("The size of the array "+list.size() );

	}

}
