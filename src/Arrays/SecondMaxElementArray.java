package Arrays;

public class SecondMaxElementArray {
	
	public int findSecondMax(int[] arr)
	{
		int max = Integer.MIN_VALUE; //5
		int secondMax = Integer.MIN_VALUE; //4
		
		for(int i=0; i< arr.length ; i++)
		{
			if(arr[i] > max)
			{
				secondMax = max;
				max = arr[i];
				
			}
			else if(arr[i]!= max && arr[i] > secondMax)
			{
				secondMax=arr[i];
				
			}
		}
		
		return secondMax;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SecondMaxElementArray sm = new SecondMaxElementArray();
		int[] arr = new int[] {10, 20, 26, 40, 12};
		System.out.println(sm.findSecondMax(arr));

	}

}
