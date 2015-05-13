package leetcode.btree.maxpath.sum;

import leetcode.btree.TreeNode;

/**
 * Given a binary tree, find the maximum path sum.
 * 
 * The path may start and end at any node in the tree.
 * 
 * <pre>
 * For example:
 * Given the below binary tree,
 * 
 *        1
 *       / \
 *      2   3
 * 
 * Return 6.
 * </pre>
 * 
 * <pre>
 *                      [5]
 *                /            \
 *              [4]              [ 8]
 *          /                /          \
 *       [11]              [13 ]           4
 *   /     \                               \ 
 *  [7 ]     2                                 1
 * </pre>
 */
public class Solution
{

	public int maxPathSum(TreeNode root)
	{
		if (root == null)
			return 0;

		int[] max = new int[1];
		max[0] = Integer.MIN_VALUE;
		maxSubSum(root, max);

		return max[0];
	}

	private int maxSubSum(TreeNode node, int[] max)
	{
		if (node == null)
			return 0;

		int leftBound = maxSubSum(node.left, max);
		int rightBound = maxSubSum(node.right, max);

		int thisMax = Math.max(leftBound, 0) + Math.max(rightBound, 0)
				+ node.val;
		max[0] = Math.max(thisMax, max[0]);

		return Math.max(node.val + Math.max(leftBound, rightBound) , 0);
	}
}
