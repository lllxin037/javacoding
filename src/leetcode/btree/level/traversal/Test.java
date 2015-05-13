package leetcode.btree.level.traversal;

import java.util.ArrayList;

import leetcode.btree.TreeNode;


public class Test
{

	private static void oneCase(int[] values)
	{
		System.out.println("#########################");
		Solution s = new Solution();

		TreeNode root = createBTree(values, 0);
		ArrayList<ArrayList<Integer>>  ret = s.levelOrder(root);
		for (int i = 0; i < ret.size(); i++)
		{
			System.out.println(ret.get(i));
		}
		
		System.out.println("#########################\n\n");
	}
	
	private static final int NULL = Integer.MIN_VALUE;
	
	private static TreeNode createBTree(int[] values, int startIndex)
	{
		if (startIndex >= values.length)
			return null;
		
		int v = values[startIndex];
		if (v == NULL)
			return null;
		
		TreeNode newNode = new TreeNode(v);
		newNode.left = createBTree(values, 2*startIndex + 1);
		newNode.right = createBTree(values, 2*startIndex + 2);
		
		return newNode;
	}
	
	public static void main(String args[])
	{
		oneCase(new int[]{});
		oneCase(new int[]{1,2});
		oneCase( new int[]{1, 2, 3, 4});
		
		oneCase( new int[]{1,2,3,4,NULL,NULL,5} ); 
		oneCase(new int[]{5,4,8,11,NULL,13,4,7,2, NULL, NULL, 1});
		
		oneCase(new int[]{1,-2,-3,1,3,-2,NULL,-1});
	}
}
 