package leetcode.btree.upside.down;

import leetcode.btree.TreeNode;

/**
 * Given a binary tree where all the right nodes are either leaf nodes with a
 * sibling (a left node that shares the same parent node) or empty, flip it
 * upside down and turn it into a tree where the original right nodes turned
 * into left leaf nodes. Return the new root.
 * 
 * <pre>
 * For example:
 * Given a binary tree {1,2,3,4,5},
 * 
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 * 
 * return the root of the binary tree [4,5,2,#,#,3,1].
 * 
 *    4
 *   / \
 *  5   2
 *     / \
 *    3   1
 * </pre>
 * 
 */
public class Solution
{
	public TreeNode upsideDownBinaryTree(TreeNode root)
	{
		TreeNode[] ret = new TreeNode[1];

		// the new root must be the farthest left node.
		doUpsideDown(root, ret);

		return ret[0];
	}

	private TreeNode doUpsideDown(TreeNode one, TreeNode[] newRoot)
	{
		if (one == null)
			return one;
		
		if (one.left == null && newRoot[0] == null)
		{
			newRoot[0] = one;
			return one;
		}

		// one.left must not be NULL
		TreeNode parent = doUpsideDown(one.left, newRoot);

		// work on one node to make sure that: right child --> left child and
		// left child --> root

		parent.left = one.right;
		parent.right = one;

		one.left = null;
		one.right = null;
		
		return one;
	}
}
