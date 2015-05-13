package leetcode.btree.search.tree.iterator;

import java.util.Stack;

import leetcode.btree.TreeNode;

public class BSTIterator
{

	private Stack<TreeNode> stack = new Stack<TreeNode>();
	private TreeNode root; 
	
	public BSTIterator(TreeNode root)
	{
		this.root = root;
		fillStack(this.root);
	}
	
	// find the min value in the constructor 
	private void fillStack(TreeNode root)
	{
		TreeNode tmp = root;
		while ( tmp != null )
		{
			stack.push( tmp );
			tmp = tmp.left;
		}
	}
	
	/** @return whether we have a next smallest number */
	public boolean hasNext()
	{
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next()
	{
		if (!hasNext())
			return -1;
		
		TreeNode cur = stack.pop();
		fillStack(cur.right);
		
		return cur.val;		
	}
}