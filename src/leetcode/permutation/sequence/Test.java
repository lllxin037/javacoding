package leetcode.permutation.sequence;

public class Test
{
	private static void oneCase(int n, int k)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		System.out.println(s1.getPermutation(n, k));
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase(1, 1);
		
		oneCase(3, 1);
		oneCase(3, 2);
		oneCase(3, 3);
		oneCase(3, 4);
		oneCase(3, 5);
		oneCase(3, 6);
		oneCase(3, 7);
		
		oneCase(4, 18);
		oneCase(4, 19);
		oneCase(4, 20);
		
		oneCase(5, 20);
	}
}
