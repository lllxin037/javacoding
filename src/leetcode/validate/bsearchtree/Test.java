package leetcode.validate.bsearchtree;

import leetcode.btree.BTree;
import leetcode.btree.TreeNode;

public class Test
{

	private static void oneCase(int[] values)
	{
		System.out.println("#########################");
		Solution s = new Solution();

		TreeNode root = BTree.createBTree(values);
		BTree.inorder(root);
		System.out.println();
		System.out.println(s.isValidBST(root));

		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase(new int[]
				{ 1, 1 });
		oneCase(new int[]
		{ 1, 2 });
		oneCase(new int[]
		{ 1, 2, 3 });
		oneCase(new int[]
		{ 2, 1, 3 });

		
	}
}
