package leetcode.balanced.btree;

/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 */

public class Solution
{
	public boolean isBalanced(TreeNode root)
	{
		if (root == null)
			return true;
		
		int[] num = new int[1];
		num[0] = 0;
		
		checkHeight(root, num);
		
		return num[0] == 0;
	}
	
	private int checkHeight(TreeNode p, int[] num)
	{
		if (num[0] == 1)
			return 0;
		
		if (p.left == null && p.right == null)
		{
			return 1;
		}
		
		int leftDepth = 1;
		if (p.left != null)
			leftDepth = checkHeight(p.left, num) + 1;

		
		int rightDepth = 1;
		if (p.right != null)
			rightDepth = checkHeight(p.right, num) + 1;
		
		
		if ( Math.abs(rightDepth - leftDepth) > 1)
		{
			num[0] = 1;
		}
		
		return Math.max(leftDepth, rightDepth);
	}
}