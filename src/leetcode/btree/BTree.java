package leetcode.btree;

import java.util.LinkedList;
import java.util.Queue;

public class BTree
{
	public static final int NULL = Integer.MIN_VALUE;

	static enum Position
	{
		LEFT, RIGHT
	};

	public static void inorder(TreeNode root)
	{
		if (root == null)
			return;

		inorder(root.left);
		System.out.print(root.val + "   ");
		inorder(root.right);
	}

	public static void preorder(TreeNode root)
	{
		if (root == null)
			return;

		System.out.print(root.val + "   ");
		preorder(root.left);
		preorder(root.right);
	}

	public static void postorder(TreeNode root)
	{
		if (root == null)
			return;

		postorder(root.left);
		postorder(root.right);
		System.out.print(root.val + "   ");
	}

	public static void levelOrder(TreeNode root)
	{
		if (root == null)
			return;

		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.add(root);

		while (!que.isEmpty())
		{
			TreeNode tmp = que.poll();
			if (tmp == null)
			{
				System.out.print("#   ");
				continue;
			}
			else
				System.out.print(tmp.val + "   ");

			if (tmp.left != null)
				que.add(tmp.left);
			else
				que.add(null);

			if (tmp.right != null)
				que.add(tmp.right);
			else
				que.add(null);
		}
	}

	public static TreeNode createBTree(int[] values)
	{
		if (values == null || values.length == 0)
			return null;

		int index = 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		// add into root node;
		TreeNode root = new TreeNode(values[index++]);
		queue.add(root);
		int levelCount = queue.size();

		// keep the current node the left or right.
		// Pop the current node before set its left/right child.
		TreeNode cur = queue.poll();
		Position next = Position.LEFT;

		for (; index < values.length; index++)
		{
			if (values[index] == NULL)
			{
				if (next == Position.RIGHT)
				{
					cur = queue.poll();
					next = Position.LEFT;
					if (--levelCount == 0)
						levelCount = queue.size();
				}
				else
					next = Position.RIGHT;
				continue;
			}
			else
			{
				// find the node.
				TreeNode p = new TreeNode(values[index]);
				if (next == Position.LEFT)
				{
					cur.left = p;
					next = Position.RIGHT;
					queue.offer(p);
				}
				else
				{
					cur.right = p;
					queue.offer(p);

					cur = queue.poll();
					next = Position.LEFT;
					if (--levelCount == 0)
						levelCount = queue.size();
				}
			}

		}

		return root;
	}

}
