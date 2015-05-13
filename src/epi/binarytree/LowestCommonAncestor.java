package epi.binarytree;

import leetcode.btree.BTree;
import leetcode.btree.TreeNode;

/**
 * Design an efficient algorithm for computing the LCA of nodes a and b in a
 * binary tree in which nodes do not have a parent pointer.
 * 
 */

public class LowestCommonAncestor
{

	public static TreeNode getLCA(TreeNode root, TreeNode a, TreeNode b)
	{
		if (root == null || a == null || b == null)
			return null;

		if (root == a || root == b)
			return root;

		TreeNode one = getLCA(root.left, a, b);
		TreeNode two = getLCA(root.right, a, b);

		if (one != null && two != null)
			return root;

		return (one == null ? two : one);
	}

	public static void main(String[] args)
	{
		TreeNode root = BTree.createBTree(new int[]
		{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, BTree.NULL, BTree.NULL,
				14, 15 });

		TreeNode found = getLCA(root, root.left.left.right,
				root.left.right.right);

		System.out.println(found.val);
	}
}
