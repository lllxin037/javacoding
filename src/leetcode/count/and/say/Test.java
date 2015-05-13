package leetcode.count.and.say;

public class Test
{
	private static void oneCase(int n)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		System.out.println(s1.countAndSay(n));
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase(1);
		oneCase(2); 
		
		oneCase(3);
		oneCase(4);
		oneCase(5);
		oneCase(6);
		oneCase(7);
		oneCase(8);

	}
}
