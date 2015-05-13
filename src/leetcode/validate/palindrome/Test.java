package leetcode.validate.palindrome;


public class Test
{
	private static void oneCase(String s)
	{
		System.out.println("#########################");
		Solution solution = new Solution();
		System.out.println(solution.isPalindrome(s));
		System.out.println("#########################\n\n");
	}


	public static void main(String[] args)
	{
		oneCase("");
		
		oneCase("1a2");
		oneCase("***A#####");
		oneCase("race a car"); 
		
		oneCase("A man, a plan, a canal: Panama");
	}
}
