package Threads;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentCache {

	private static final Map<String, String> cache = new ConcurrentHashMap<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<9;i++)
		{
			final int threadNum =i;
			String key = "Key @ "+threadNum;
			new Thread(() -> {
				for(int j=0;j<3;j++)
				{
					String value = getCachedValue(key);
					System.out.println("Thread "+Thread.currentThread().getName() + " : Key = "+key+" Value: "+value);
				}
			}).start();
		}
		

	}
	private static String getCachedValue(String key) {
		// TODO Auto-generated method stub
		
		String value = cache.get(key);
		if(value == null)
		{
			value = compute(key);
			cache.put(key, value);
		}
		return value;
	}
	private static String compute(String key) {
		// TODO Auto-generated method stub
		System.out.println("The key is not present in the cache, so going to compute");
		try
		{
			Thread.sleep(500);
		}
		catch(InterruptedException e)
		{
			throw new RuntimeException(e);
		}
		return "Value of key " +key;
	}

}
