package leetcode.preorder.traversal;

import java.util.ArrayList;
import java.util.Stack;

import leetcode.preorder.traversal.SolutionTest.TreeNode;


/**
 * <pre>
 * {1,#,2,3} 
 * 
 * to 
 * 
 * [3,2,1]
 * 
 * </pre>
 * 
 * don't use recursive algorithm.
 */
public class Solution
{
	public ArrayList<Integer> preorderTraversal(TreeNode root)
	{
		ArrayList<Integer> ret = new ArrayList<Integer>();
		
		if (root == null)
			return ret;
		
		Stack<TreeNode> stack = new  Stack<TreeNode>();
			
		TreeNode cur = null;
		stack.push( root );		

		while (!stack.isEmpty())
		{
			cur = stack.pop();			
			ret.add( Integer.valueOf(cur.val) );
			
			if (cur.right != null)
				stack.push(cur.right);
			
			if (cur.left != null )
				stack.push( cur.left );
		}
		
		return ret;
	}
}