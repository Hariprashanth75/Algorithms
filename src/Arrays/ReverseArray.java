package Arrays;

public class ReverseArray {

	public void reversedArray(int[] arr, int start , int end)
	{
		int temp=0;
		while(start < end)
		{
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
		printArray(arr);
		
	}
	
	public void printArray(int[] arr)
	{
		for(int i=0 ; i< arr.length ; i++)
		{
			System.out.println(arr[i]);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseArray r = new ReverseArray();
		int[] arr = new int[] {10, 39, 80, 20, 50, 70, 100};
		int start=2;
		int end=5;
		r.reversedArray(arr, start, end);
		

	}

}
