package leetcode.balanced.btree;

/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 */

public class Solution1
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
	
	private int[] checkHeight(TreeNode p, int[] num)
	{
		// 0 is max, 1 is min
		int[] depth = new int[2];
		if (num[0] == 1)
			return depth;
		
		if (p.left == null && p.right == null)
		{
			depth[0] = 1;
			depth[1] = 1;
			return depth;
		}
		
		int[] leftDepth = new int[2];
		if (p.left != null)
		{
			leftDepth = checkHeight(p.left, num);
			leftDepth[0] = leftDepth[0] + 1;
			leftDepth[1] = leftDepth[1] + 1;
		}
		else
		{
			leftDepth[0] = 1;
			leftDepth[1] = 1;
		}
		
		int[] rightDepth = new int[2];
		if (p.right != null)
		{
			rightDepth = checkHeight(p.right, num);
			rightDepth[0] = rightDepth[0] + 1;
			rightDepth[1] = rightDepth[1] + 1;
		}
		else
		{
			rightDepth[0] = 1;
			rightDepth[1] = 1;
		}
		
		int max = Math.max(leftDepth[0], leftDepth[1]);
		max = Math.max(max, rightDepth[0]);
		max = Math.max(max, rightDepth[1]);
		depth[0] = Math.max(max, depth[0]); 
		
		int min = Math.min(leftDepth[0], leftDepth[1]);
		min = Math.min(min, rightDepth[0]);
		min = Math.min(min, rightDepth[1]);
		depth[1] = Math.min(min, depth[0]); 
		
		if ( (max -min ) > 1)
		{
			num[0] = 1;
		}
		
		return depth;
	}
}