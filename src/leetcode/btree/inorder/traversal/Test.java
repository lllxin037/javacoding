package leetcode.btree.inorder.traversal;

import leetcode.btree.BTree;
import leetcode.btree.TreeNode;

public class Test
{
	private static void oneCase(int[] values)
	{
		System.out.println("#########################");
		Solution s = new Solution();

		TreeNode root = BTree.createBTree(values);
		System.out.println(s.inorderTraversal(root));

		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase(new int[]
		{ 1, 2, 2 });
		oneCase(new int[]
		{ 1, 2, 1 });

		oneCase(new int[]
		{ 1, 2, 2, 3, 4, 4, 3 });
		oneCase(new int[]
		{ 1, 2, 2, BTree.NULL, 3, BTree.NULL, 3 });

		oneCase(new int[]
		{ 1, 2, 2, 3, BTree.NULL, BTree.NULL, 3 });

		oneCase(new int[]
		{ 1, 2, 3, 3, BTree.NULL, 2, BTree.NULL });
	}
}
