package Arrays;

public class Palindrome {
	
	public boolean isPalindrome(String str)
	{
		char[] toChars = str.toCharArray();
		int start = 0;
		int end = toChars.length-1;
		while(start < end)
		{
			if(toChars[start] != toChars[end])
			{
				return false;
			}
			start ++;
			end--;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Palindrome pm = new Palindrome();
		String madam = "madam";
		String that = "that";
		System.out.println("String 1"+ pm.isPalindrome(madam));
		System.out.println("String 1"+ pm.isPalindrome(that));

	}

}
