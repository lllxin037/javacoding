package leetcode.pascal.triangle;

import java.util.ArrayList;


public class Test
{
	private static void oneCase(int numRows)
	{
		System.out.println("#########################");
		Solution s = new Solution();
		dump2DArray(s.generate(numRows));
		System.out.println("#########################\n\n");
	}

	private static void dump2DArray( ArrayList<ArrayList<Integer>> array)
	{
		for (int i = 0; i < array.size(); i++)
		{
			System.out.println( array.get(i));
		}
	}
	public static void main(String[] args)
	{ 
		oneCase(0);
		oneCase(1);
		oneCase(4);
		oneCase(10);			
	}
	
}
