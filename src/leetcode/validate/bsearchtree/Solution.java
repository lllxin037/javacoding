package leetcode.validate.bsearchtree;

import leetcode.btree.TreeNode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * <pre>
 * Assume a BST is defined as follows:
 * 
 *     The left subtree of a node contains only nodes with keys less than the node's key.
 *     The right subtree of a node contains only nodes with keys greater than the node's key.
 *     Both the left and right subtrees must also be binary search trees.
 * </pre>
 * 
 */

public class Solution
{
	public boolean isValidBST(TreeNode root)
	{	
		boolean[] ret = new boolean[1];
		ret[0] = true;
		checkValidBST(root, null, ret);
		
		return ret[0];
	}
	
	private TreeNode checkValidBST(TreeNode p, TreeNode pre, boolean[] flag)
	{
		if (p == null)
			return pre;
		
		TreeNode last = checkValidBST(p.left, pre, flag);
		if (!flag[0])
			return null;
		
		if (last != null && p.val <= last.val)
		{
			flag[0] = false;
		}
		
		return checkValidBST(p.right, p, flag);
	}

}
