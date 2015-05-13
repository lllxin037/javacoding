package leetcode.symmetric.tree;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric
 * around its center).
 * 
 * <pre>
 * For example, this binary tree is symmetric:
 * 
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 
 * But the following is not:
 * 
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * </pre>
 * 
 * Note: Bonus points if you could solve it both recursively and iteratively.
 * 
 */

public class RecursiveSolution
{
	public boolean isSymmetric(TreeNode root)
	{
		if (root == null)
			return true;

		if (root.left == null && root.right == null)
			return true;

		return checkSymmetic(root.left, root.right);
	}

	private boolean checkSymmetic(TreeNode left, TreeNode right)
	{
		if (left == null && right == null)
			return true;
		
		if (left == null && right != null)
			return false;

		if (right == null && left != null)
			return false;

		if (left.val != right.val)
			return false;
		
		boolean ret = checkSymmetic(left.left, right.right);
		if (ret == false)
			return false;
		
		return checkSymmetic(left.right, right.left);
	}
}