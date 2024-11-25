package Arrays;

public class MissingNumber {

	public void missingNumber(int[] arr)
	{
		int n = arr.length + 1;
		int sum = n * (n+1)/2;
		
		for(int num : arr)
		{
			sum = sum - num;
		}
		
		System.out.println(sum);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MissingNumber ms = new MissingNumber();
		int[] arr = new int[] {1,2,4,5,6,7};
		System.out.println("The missing number is");
		ms.missingNumber(arr);

	}

}
