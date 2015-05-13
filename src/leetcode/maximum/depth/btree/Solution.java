package leetcode.maximum.depth.btree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root
 * node down to the farthest leaf node.
 * 
 */

public class Solution
{
	public int maxDepth(TreeNode root)
	{
		if (root == null)
			return 0;
		
		int maxDepth = 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		// use the null as the level separator.
		queue.offer(root);
		queue.offer(null);

		while (!queue.isEmpty())
		{
			TreeNode p = queue.poll();
			if (p == null)
			{
				maxDepth++;
				if (!queue.isEmpty())
					queue.offer(null);

				continue;
			}

			if (p.left != null)
				queue.offer(p.left);
			if (p.right != null)
				queue.offer(p.right);
		}

		return maxDepth;
	}
}