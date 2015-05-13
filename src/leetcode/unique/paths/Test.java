package leetcode.unique.paths;


public class Test
{

	private static void oneCase(int m, int n)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		System.out.println(s1.uniquePaths(m, n));
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase(1, 1);
		
		oneCase(2, 2);
		oneCase(3, 3);
		oneCase(3, 7);
	}
}
