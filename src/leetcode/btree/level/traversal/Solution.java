package leetcode.btree.level.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import leetcode.btree.TreeNode;

/**
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
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
 * return its level order traversal as:
 * 
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * </pre>
 * 
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized
 * on OJ.
 * 
 * OJ's Binary Tree Serialization:
 * 
 * The serialization of a binary tree follows a level order traversal, where '#'
 * signifies a path terminator where no node exists below.
 * 
 * <pre>
 * Here's an example:
 * 
 *    1
 *   / \
 *  2   3
 *     /
 *    4
 *     \
 *      5
 * </pre>
 * 
 * The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
 * 
 */
public class Solution
{
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root)
	{
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return ret;

		Queue<TreeNode> oneLevel = new LinkedList<TreeNode>();
		Queue<TreeNode> anotherLevel = new LinkedList<TreeNode>();
		oneLevel.offer(root);

		int level = 0;

		ArrayList<Integer> array = new ArrayList<Integer>();
		do
		{
			TreeNode p = null;

			if (level % 2 == 0)
			{
				p = oneLevel.poll();
				if (p == null)
				{
					level++;

					ArrayList<Integer> tmp = new ArrayList<Integer>();
					tmp.addAll(array);
					ret.add(tmp);
					array.clear();
					
					if (anotherLevel.peek() == null)
						break;
					else
						continue;
				}

				array.add(Integer.valueOf(p.val));
				
				if (p.left != null)
					anotherLevel.offer(p.left);
				if (p.right != null)
					anotherLevel.offer(p.right);
			}
			else
			{
				p = anotherLevel.poll();
				if (p == null)
				{
					level++;

					ArrayList<Integer> tmp = new ArrayList<Integer>();
					tmp.addAll(array);
					ret.add(tmp);
					array.clear();
					
					if (oneLevel.peek() == null)
						break;
					else
						continue;
				}

				array.add(Integer.valueOf(p.val));
				
				if (p.left != null)
					oneLevel.offer(p.left);
				if (p.right != null)
					oneLevel.offer(p.right);
			}
		}
		while (true);
		
		return ret;
	}
}
