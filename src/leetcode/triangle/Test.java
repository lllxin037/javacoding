package leetcode.triangle;

import java.util.ArrayList;

public class Test
{
	private static void oneCase(int[][] triangle)
	{
		System.out.println("#########################");
		Solution s = new Solution();
		System.out.println(s.minimumTotal( createTriangle(triangle)) );
		System.out.println("#########################\n\n");
	}

	private static ArrayList<ArrayList<Integer>> createTriangle(int[][] triangle)
	{
		int rows = triangle.length;
		if (rows == 0)
			return new ArrayList<ArrayList<Integer>>();
		
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>(rows);
		for (int i = 0; i < rows; i++)
		{
			int[] meta = triangle[i];
			ArrayList<Integer> oneRow = new ArrayList<Integer>();
			for (int j = 0; j < meta.length; j++)
			{
				oneRow.add(meta[j]);
			}
			ret.add(oneRow);
		}
		
		return ret;
	}
	
	public static void main(String[] args)
	{ 
		oneCase(new int[][] {});
		oneCase(new int[][] {{2}});
		oneCase(new int[][] {{2},{3,4},{6,5,7}, {4,1,8,3}});	
		
		oneCase(new int[][] {{-1},{2,3},{1,-1,-3}});
		
	}
}
