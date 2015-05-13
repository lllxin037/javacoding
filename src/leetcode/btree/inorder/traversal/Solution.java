package leetcode.btree.inorder.traversal;

import java.util.ArrayList;
import java.util.Stack;

import leetcode.btree.TreeNode;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * <pre>
 * For example:
 * Given binary tree {1,#,2,3},
 * 
 *    1
 *     \
 *      2
 *     /
 *    3
 * 
 * return [1,3,2].
 * </pre>
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 */

public class Solution
{
	public ArrayList<Integer> inorderTraversal(TreeNode root)
	{
		ArrayList<Integer> ret = new ArrayList<Integer>();

		Stack<TreeNode> nodes = new Stack<TreeNode>();
		TreeNode p = root;

		while (!nodes.isEmpty() || p != null)
		{
			if (p != null)
			{
				nodes.push(p);
				p = p.left;
			}
			else
			{
				p = nodes.pop();
				ret.add(p.val);
				p = p.right;
			}
		}

		return ret;
	}
}
