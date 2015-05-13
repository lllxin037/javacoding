package leetcode.minimum.depth.btree;

import leetcode.btree.BTree;
import leetcode.btree.TreeNode;


public class Test
{

	private static void oneCase(int[] values)
	{
		System.out.println("#########################");
		Solution s = new Solution();

		TreeNode root = BTree.createBTree(values);
		System.out.println(s.minDepth(root));
		
		System.out.println("#########################\n\n");
	}
	
	private static final int NULL = Integer.MIN_VALUE;
	

	
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
 