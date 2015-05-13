import java.util.Stack;

import leetcode.btree.BTree;
import leetcode.btree.TreeNode;

/**
 * Nth largest from tree. Given a binary search tree where the left node is
 * smaller and the right node is larger. Calculate the Nth largest number in the
 * tree throwing exception when there is less than N elements in the tree.
 * 
 */

public class NthLargestBtree
{

	// like the threaded binary tree iteration.

	public TreeNode getNthLargestNode(TreeNode root, int n)
	{
		if (root == null || n <= 0)
			throw new IllegalArgumentException();

		Stack<TreeNode> stack = new Stack<TreeNode>();

		int count = 0;
		TreeNode node = root;
		while (node != null || !stack.isEmpty())
		{
			if (node != null)
			{
				stack.push(node);
				node = node.right;
			}
			else
			{
				node = stack.pop();
				// visit
				count++;
				if (count == n)
					return node;
				node = node.left;
			}
		}

		throw new IllegalArgumentException();
	}

	public TreeNode getInMorris(TreeNode root, int n)
	{
		TreeNode p = root;
		int count = 0;
		TreeNode ret = null;
		
		while (p != null)
		{
			if (p.right != null)
			{
				TreeNode pre = p.right;
				while (pre.left != null && pre.left != p)
					pre = pre.left;
				if (pre.left == null)
				{
					pre.left = p;
					p = p.right;
				}
				else
				{
					pre.left = null;
					// visit and revert changes.
					count++;
					if (count == n)
						ret = p;
					
					p = p.left;
				}

			}
			else
			{
				// visit

				count++;
				if (count == n)
					ret = p;

				p = p.left;
			}
		}

		if (ret == null)
			throw new IllegalArgumentException();
		return ret;
		
	}

	public static void main(String[] args)
	{
		NthLargestBtree tree = new NthLargestBtree();
		TreeNode root = BTree.createBTree(new int[]
		{ 8, 3, 10, 1, 6, BTree.NULL, 14, BTree.NULL, BTree.NULL, 4, 7, 13 });

		System.out.println(tree.getInMorris(root, 1).val);
		System.out.println(tree.getInMorris(root, 2).val);
		System.out.println(tree.getInMorris(root, 3).val);
		System.out.println(tree.getInMorris(root, 4).val);
		System.out.println(tree.getInMorris(root, 6).val);

		System.out.println(tree.getNthLargestNode(root, 100).val);

	}
}
