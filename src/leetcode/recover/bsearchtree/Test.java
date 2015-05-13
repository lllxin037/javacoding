package leetcode.recover.bsearchtree;

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
		s.recoverTree(root);
		BTree.inorder(root);
		System.out.println();

		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		/*
		 * oneCase(new int[] { 1, 2 }); oneCase(new int[] { 1, 2, 3 });
		 * oneCase(new int[] { 0, 1 }); oneCase(new int[] { 2, BTree.NULL, 1 });
		 * 
		 * oneCase(new int[] { 2, 3, 1 });
		 * 
		 * oneCase(new int[] { 2, BTree.NULL, 1, BTree.NULL, 3 });
		 * 
		 * oneCase(new int[] { 3, BTree.NULL, 2, BTree.NULL, 1 });
		 * 
		 * oneCase(new int[] { 1, BTree.NULL, 2, 3 });
		 * 
		 * oneCase(new int[] { 146, 71, -13, 55, BTree.NULL, 231, 399, 321,
		 * BTree.NULL, BTree.NULL, BTree.NULL, BTree.NULL, BTree.NULL, -33 });
		 * 
		 * oneCase(new int[] { 3, BTree.NULL, 2, BTree.NULL, 1 });
		 * 
		 * oneCase(new int[] { 3, 4, 2, 1, BTree.NULL, BTree.NULL, 5 });
		 * 
		 * oneCase(new int[] { 2, 3, 4, 1, BTree.NULL, BTree.NULL, 5 });
		 * 
		 * oneCase(new int[] { 2, BTree.NULL, 3, 1 });
		 * 
		 * oneCase(new int[] { 10, 5, 15, 0, 8, 13, 20, 2, -5, 6, 9, 12, 14, 18,
		 * 25 });
		 */

		oneCase(new int[]
		{ 4, 1, BTree.NULL, 2, BTree.NULL, 3 });
	}
}
