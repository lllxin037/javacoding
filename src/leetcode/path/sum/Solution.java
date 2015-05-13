package leetcode.path.sum;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
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
 *          /  \      \
 *         7    2      1
 * 
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * </pre>
 */
public class Solution
{
	public boolean hasPathSum(TreeNode root, int sum)
	{
		if (root == null)
			return false;
		
		if (root.left == null && root.right == null)
		{
			return root.val == sum;
		}
		
		if (root.left != null)
		{
			boolean ret = hasPathSum(root.left, sum - root.val);
			if (ret == true)
				return ret;
		}
		
		if (root.right != null)
		{
			boolean ret = hasPathSum(root.right, sum - root.val);		
			if (ret == true)
				return ret;		
		}
		
		return false;		
	}
}