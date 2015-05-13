package leetcode.symmetric.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

public class Solution
{
	public boolean isSymmetric(TreeNode root)
	{
		if (root == null)
			return true;

		List<Integer> next = new ArrayList<Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		// use null as level separate

		queue.offer(root);
		queue.offer(null);

		boolean ret = false;
		while (!queue.isEmpty())
		{
			TreeNode p = queue.poll();
			if (p != null)
			{
				if (p.left != null)
				{
					queue.offer(p.left);
					next.add(p.left.val);
				}
				else
					next.add(null);
				
				if (p.right != null)
				{
					queue.offer(p.right);
					next.add(p.right.val);
				}
				else
					next.add(null);
				
				continue;
			}

			if (queue.isEmpty())
			{
				ret = checkSymmetric(next);
				if (ret == false)
					return false;
				continue;
			}

			ret = checkSymmetric(next);
			if (ret == false)
				return false;

			queue.offer(null);
			next.clear();
		}

		return ret;
	}

	private boolean checkSymmetric(List<Integer> oneResult)
	{
		int len = oneResult.size();

		if (len % 2 == 1)
			return false;

		for (int i = 0; i < len / 2; i++)
		{
			Integer start = oneResult.get(i);
			Integer end = oneResult.get(len -1 -i);
			
			if ( start == end && start == null )
				continue;
			
			if ( start != null && end == null )
				return false;
			
			if ( end != null && start == null )
				return false;
			
			if (start.intValue() != end.intValue())
				return false;
		}

		return true;
	}
}