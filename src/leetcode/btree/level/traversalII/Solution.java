package leetcode.btree.level.traversalII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes'
 * values. (ie, from left to right, level by level from leaf to root).
 * 
 * <pre>
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 * 
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 
 * return its bottom-up level order traversal as:
 * 
 * [
 *   [15,7]
 *   [9,20],
 *   [3],
 * ]
 * </pre>
 * 
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized
 * on OJ.
 * 
 */
public class Solution
{
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root)
	{
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return ret;

		Stack<ArrayList<Integer>> stack = new Stack<ArrayList<Integer>>();

		// use null as separate to distinct different levels.
		Queue<TreeNode> oneLevel = new LinkedList<TreeNode>();
		oneLevel.offer(root);
		oneLevel.offer(null);

		ArrayList<Integer> array = new ArrayList<Integer>();
		do
		{
			TreeNode p = oneLevel.poll();
			if (p == null)
			{
				ArrayList<Integer> tmp = new ArrayList<Integer>();
				tmp.addAll(array);
				stack.push(tmp);
				
				array.clear();

				if (oneLevel.peek() == null)
					break;
				else
				{	
					oneLevel.offer(null);					
					continue;
				}
			}

			array.add(Integer.valueOf(p.val));

			if (p.left != null)
				oneLevel.offer(p.left);
			if (p.right != null)
				oneLevel.offer(p.right);

		}
		while (true);

		while (!stack.isEmpty())
		{
			ret.add(stack.pop());
		}
		
		return ret;
	}
}
