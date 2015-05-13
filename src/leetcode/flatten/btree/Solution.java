package leetcode.flatten.btree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * <pre>
 * For example,
 * Given
 * 
 *          1
 *         / \
 *        2   5
 *       / \   \
 *      3   4   6
 * 
 * The flattened tree should look like:
 * 
 *    1
 *     \
 *      2
 *       \
 *        3
 *         \
 *          4
 *           \
 *            5
 *             \
 *              6
 * </pre>
 * 
 * click to show hints.
 * 
 * Hints:
 * 
 * If you notice carefully in the flattened tree, each node's right child points
 * to the next node of a pre-order traversal.
 * 
 * 
 */

public class Solution
{
	public void flatten(TreeNode root)
	{
		TreeNode p = root;

		while (p != null)
		{
			if (p.left == null)
			{
				p = p.right;
				continue;
			}

			boolean leftChild = true;
			TreeNode q = p.left;
			TreeNode qParent = p;

			// when remove the node, make sure set NULL to the node for removing
			while (q.right != null)
			{
				qParent = q;
				q = q.right;
				
				leftChild = false;
			}

			q.right = p.right;
			p.right = q;

			if (leftChild)
				qParent.left = null;
			else
				qParent.right = null;

		}
	}

}