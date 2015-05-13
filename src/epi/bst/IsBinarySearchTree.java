package epi.bst;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.btree.BTree;
import leetcode.btree.TreeNode;

public class IsBinarySearchTree
{
	// inorder traversal. Make sure root node is less than right node and larger
	// than left node.
	public static boolean check(TreeNode root)
	{
		TreeNode[] prev = new TreeNode[1];
		return checkHelper(root, prev);
	}

	private static boolean checkHelper(TreeNode node, TreeNode[] prev)
	{
		if (node == null)
			return true;

		if (!checkHelper(node.left, prev))
			return false;

		if (prev[0] != null && node.val < prev[0].val)
			return false;

		prev[0] = node;
		return checkHelper(node.right, prev);
	}

	public static boolean checkWithMaxAndMin(TreeNode root)
	{
		return checkWithMaxAndMinHelper(root, Integer.MIN_VALUE,
				Integer.MAX_VALUE);
	}

	private static boolean checkWithMaxAndMinHelper(TreeNode node, int min,
			int max)
	{
		if (node == null)
			return true;

		if (node.val < min || node.val > max)
			return false;

		return checkWithMaxAndMinHelper(node.left, min, node.val)
				&& checkWithMaxAndMinHelper(node.right, node.val, max);
	}

	public static boolean checkBFS(TreeNode root)
	{
		if (root == null)
			return true;

		Queue<QNode> qNodes = new LinkedList<QNode>();
		qNodes.add(new QNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

		while (!qNodes.isEmpty())
		{
			QNode one = qNodes.poll();
			if (one.node.val < one.min || one.node.val > one.max)
				return false;

			if (one.node.left != null)
				qNodes.offer(new QNode(one.node.left, one.min, one.node.val));
			if (one.node.right != null)
				qNodes.offer(new QNode(one.node.right, one.node.val, one.max));
		}

		return true;

	}

	public static void main(String[] args)
	{
		TreeNode root = BTree.createBTree(new int[]
		{ 3, 2, 5, 1, 4 });
		// expect false.
		System.out.println(checkBFS(root));

		root = BTree.createBTree(new int[]
		{ 4, 2, 5, 1, 3 });
		// expect true.
		System.out.println(checkBFS(root));
	}

	private static class QNode
	{
		int min;
		int max;
		TreeNode node;

		QNode(TreeNode node, int min, int max)
		{
			this.node = node;
			this.max = max;
			this.min = min;
		}
	}

}
