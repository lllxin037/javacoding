package leetcode.remove.element;

public class Test
{
	private static void oneCase(int[] A, int elem)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		int len = s1.removeElement(A, elem);
		for (int i = 0; i < len; i++)
			System.out.print(A[i] + "   ");

		System.out.println();
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		/**/
		oneCase(new int[]
		{ 4, 5 }, 4);
	}
}
