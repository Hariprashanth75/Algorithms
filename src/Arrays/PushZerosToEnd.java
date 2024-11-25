package Arrays;

public class PushZerosToEnd {
	
	public void pushZeros(int[] arr)
	{
		int j=0;
		
		for(int i=0; i< arr.length;i++)
		{
			
			if(arr[j]==0 && arr[i]!=0)
			{
			int temp=arr[i];
			arr[i] = arr[j];
			arr[j] =  temp;
			}
			if(arr[j]!=0)
			{
				j++;
			}
		}
		
		print(arr);
	}
	
	public void print(int[] arr)
	{
		for(int i=0; i< arr.length; i++)
		{
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = new int[] {10, 0, 20, 30, 0, 15, 0, 40};
		PushZerosToEnd push = new PushZerosToEnd();
		push.pushZeros(arr);

	}

}
