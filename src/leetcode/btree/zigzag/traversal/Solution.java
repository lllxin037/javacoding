package leetcode.btree.zigzag.traversal;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
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
 * return its zigzag level order traversal as:
 * 
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * </pre>
 * 
 */

public class Solution
{
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root)
	{
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return ret;

		Stack<TreeNode> one = new Stack<TreeNode>();
		Stack<TreeNode> another = new Stack<TreeNode>();				
		one.push(root);
		
		ArrayList<Integer> oneResult = new ArrayList<Integer>();

		Stack<TreeNode> source = one;
		Stack<TreeNode> target = another;
		
		int level = 0;
		
		do 
		{						
			if (source.isEmpty())
			{
				if ( target.isEmpty() )
				{					
					ret.add(oneResult);
					oneResult = new ArrayList<Integer>();
					return ret;
				}

				level++;				

				if (level % 2 == 1)
				{
					source = another;
					target = one;
				}
				else
				{
					source = one;
					target = another;
				}

				ret.add(oneResult);
				oneResult = new ArrayList<Integer>();
				continue;
			}
			
			TreeNode p = source.pop();
			oneResult.add( p.val );
			
			if (level % 2 == 0)
			{
				if (p.left != null)
					target.push(p.left);				
				if (p.right != null)
					target.push(p.right);				
			}
			else
			{
				if (p.right != null)
					target.push(p.right);
				if (p.left != null)
					target.push(p.left);				
			}
		}
		while (true);
	}
}