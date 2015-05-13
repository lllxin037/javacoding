package leetcode.same.tree;

import leetcode.btree.TreeNode;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * 
 * Two binary trees are considered equal if they are structurally identical and
 * the nodes have the same value.
 * 
 */

public class Solution
{
	public boolean isSameTree(TreeNode p, TreeNode q)
	{
		if (p == null || q == null)
			return p == q;

		if (p.val != q.val)
			return false;

		boolean ret = isSameTree(p.left, q.left);
		if (ret == false)
			return false;

		return isSameTree(p.right, q.right);
	}

}
