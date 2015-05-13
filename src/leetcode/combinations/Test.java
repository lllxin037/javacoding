package leetcode.combinations;

import java.util.ArrayList;

public class Test
{
	private static void oneCase(int n, int k)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		ArrayList<ArrayList<Integer>> values = s1.combine(n, k);
		for (int i = 0; i < values.size(); i++)
		{
			System.out.println(values.get(i));
		}

		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		/**/	
		oneCase(0, 0);		
		oneCase(1, 0); 
		
		oneCase(1, 1);	
		oneCase(2, 1);
		
		oneCase(2, 2);
		oneCase(4, 2);

		oneCase(4, 3);

		oneCase(4, 4);
		
		oneCase(4, 5);
	}
}
