package epi.stackandqueues;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.btree.BTree;
import leetcode.btree.TreeNode;

/**
 * 
 *
 */

public class BinaryTreeLevelOrderTemplate
{
	public static void print(TreeNode root)
	{
		if (root == null)
			return;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int count = queue.size();
		
		while (!queue.isEmpty())
		{
			TreeNode node = queue.poll();
			
			System.out.print(node.val + "  ");
			if (node.left != null)
				queue.offer(node.left);
			if (node.right != null)
				queue.offer(node.right);
		
			if (--count == 0)
			{
				System.out.println();
				count = queue.size();
			}
		}
	}

	public static void main(String[] args)
	{
		TreeNode root = BTree.createBTree(new int[]
		{ 314, 6, 6, 271, 561, 2, 271, 28, 0, BTree.NULL, 3, BTree.NULL, 1,
				BTree.NULL, 28 });

		print(root);
	}
}
