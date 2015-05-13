package leetcode.path.sumII;

import java.util.ArrayList;

/**
 * 
 Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * <pre>
 * For example:
 * Given the below binary tree and sum = 22,
 * 
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 
 * return
 * 
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 * </pre>
 */
public class Solution
{
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum)
	{
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> oneResult = new ArrayList<Integer>();
		retreivePathSum(root, sum, ret, oneResult);
		return ret;
	}

	private void retreivePathSum(TreeNode root, int sum,
			ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> oneResult)
	{
		if (root == null)
			return;

		if (root.left == null && root.right == null)
		{
			if (root.val == sum)
			{
				oneResult.add(Integer.valueOf(root.val));
				ArrayList<Integer> tmp = new ArrayList<Integer>();
				tmp.addAll(oneResult);
				ret.add(tmp);
				
				oneResult.remove(oneResult.size() - 1);
			}
			
			return;
		}

		oneResult.add(Integer.valueOf(root.val));
		if (root.left != null)
		{
			retreivePathSum(root.left, sum - root.val, ret, oneResult);
		}

		if (root.right != null)
		{
			retreivePathSum(root.right, sum - root.val, ret, oneResult);
		}
		oneResult.remove(oneResult.size() - 1);
	}
}