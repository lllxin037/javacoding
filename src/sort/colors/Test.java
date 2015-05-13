package sort.colors;

public class Test
{
	private static void oneCase(int[] A)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();
		s1.sortColors(A);
		
		if (A != null)
		{
			for (int i = 0; i < A.length; i++)
			{
				System.out.print(A[i] + "    ");
			}
		}
		System.out.println();

		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		/*
		oneCase(new int[] {});

		oneCase(new int[] {0});
		oneCase(new int[] {2});
		
		oneCase(new int[] {0, 2});
		
		oneCase(new int[] {2, 2});
		
		oneCase(new int[] {2, 0, 1});*/
		
		oneCase(new int[] {2, 0, 0, 1, 2});
	}
}
