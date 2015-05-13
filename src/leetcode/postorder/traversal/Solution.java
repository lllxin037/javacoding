package leetcode.postorder.traversal;

import java.util.ArrayList;
import java.util.Stack;

import leetcode.postorder.traversal.SolutionTest.TreeNode;


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
	public ArrayList<Integer> postorderTraversal(TreeNode root)
	{
		ArrayList<Integer> ret = new ArrayList<Integer>();
		
		if (root == null)
			return ret;
		
		Stack<TreeNode> stack = new  Stack<TreeNode>();
			
		TreeNode cur = null;
		TreeNode pre = null;
		stack.push( root );		

		while (!stack.isEmpty())
		{
			cur = stack.peek();
			if ( (cur.left == null && cur.right == null)
					|| (pre != null && ( cur.left == pre || cur.right == pre)) )
			{
				stack.pop();
				ret.add( Integer.valueOf(cur.val) );
				
				pre = cur;
				continue;
			}
			
			if (cur.right != null)
				stack.push(cur.right);
			
			if (cur.left != null )
				stack.push( cur.left );
		}
		
		return ret;
	}
}