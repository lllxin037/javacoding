package epi.binarytree;

import leetcode.btree.BTree;
import leetcode.btree.TreeNode;

/**
 * Write a function that takes as input the root of a binary tree and returns
 * true or false depending on whether the tree is balanced. Use O(h) additional
 * storage, where h is the height of the tree.
 * 
 */

public class TestBalancedTree
{
	public static boolean isBalanced(TreeNode root)
	{
		if (root == null)
			return true;

		return checkHeight(root) != -1;
	}

	private static int checkHeight(TreeNode node)
	{
		if (node == null)
			return 0;

		int leftHeight = checkHeight(node.left);
		if (leftHeight == -1)
			return -1;

		int rightHeight = checkHeight(node.right);
		if (rightHeight == -1)
			return -1;

		if (Math.abs(rightHeight - leftHeight) > 1)
			return -1;

		return Math.max(leftHeight, rightHeight) + 1;
	}

	public static void main(String[] args)
	{
		TreeNode root = BTree.createBTree(new int[]
		{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, BTree.NULL, BTree.NULL,
				14, 15 });

		System.out.println(isBalanced(root));

		root = BTree.createBTree(new int[]
		{ 7, 4, BTree.NULL, 3 });
		System.out.println(isBalanced(root));

		root = BTree.createBTree(new int[]
		{ 7, BTree.NULL, 4, 3 });
		System.out.println(isBalanced(root));

	}
}
