package Arrays;

public class ResizeArray {
	
	public int[] resize(int[] arr, int capacity)
	{
		int[] temp = new int[capacity];
		for(int i=0;i<arr.length;i++)
		{
			temp[i] = arr[i];
		}
		
		return temp;
	}
	
	public void print(int[] arr)
	{
		for(int i=0; i< arr.length;i++) 
		{
			System.out.println(" "+arr[i]);
		}
	}
	
	public void add(int[] arr, int element)
	{
		arr[arr.length-1] = element;
		print(arr);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ResizeArray ra = new ResizeArray();
		int[] arr = new int[] {10, 20, 30, 50};
		System.out.println("Size of array before resize"+ arr.length);
		ra.print(arr);
		arr = ra.resize(arr, 5);
		System.out.println("Size of array after resize"+ arr.length);
		System.out.println("After adding new element to resized array");
		ra.add(arr, 23);
		

	}

}
