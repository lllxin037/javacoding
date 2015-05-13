package leetcode.minimum.depth.btree;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.btree.TreeNode;

/**
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 */
public class Solution
{
	public int minDepth(TreeNode root)
	{
		if (root == null)
			return 0;

		int depth = 0;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(null);

		while (!queue.isEmpty())
		{
			TreeNode one = queue.poll();
			if (one == null) // end of the level
			{
				queue.offer(null);
				depth++;
				continue;
			}

			if (one.left == null && one.right == null)
				return depth + 1;
			if (one.left != null)
				queue.offer(one.left);
			if (one.right != null)
				queue.offer(one.right);
		}

		return depth;
	}
}