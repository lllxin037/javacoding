package sum.root;

import java.util.Stack;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
 * could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * <pre>
 * For example,
 * 
 *     1
 *    / \
 *   2   3
 * 
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * 
 * Return the sum = 12 + 13 = 25.
 * </pre>
 * 
 */

/**
 * 
 */
public class Solution
{
	public int sumNumbers(TreeNode root)
	{
		if (root == null)
			return 0;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		int oneNumber = 0;
		int ret = 0;

		TreeNode placeHolder = new TreeNode(-1);
		while (!stack.isEmpty())
		{
			TreeNode p = stack.pop();
			if (p == placeHolder)
			{
				oneNumber = (oneNumber) / 10;
				continue;
			}

			oneNumber = oneNumber * 10 + p.val;

			if (p.right == null && p.left == null)
			{
				ret += oneNumber;

				oneNumber = (oneNumber - p.val) / 10;
				continue;
			}

			if (p.right != null || p.left != null)
			{
				stack.push(placeHolder);
			}

			if (p.right != null)
				stack.push(p.right);

			if (p.left != null)
				stack.push(p.left);
		}

		return ret;
	}
}
