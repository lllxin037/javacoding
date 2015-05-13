package epi.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BTreeWithParent
{
	public static final int NULL = Integer.MIN_VALUE;

	static enum Position
	{
		LEFT, RIGHT
	};

	public static void inorder(TreeNodeWithParent root)
	{
		if (root == null)
			return;

		inorder(root.left);
		System.out.print(root.val + "   ");
		inorder(root.right);
	}

	public static void preorder(TreeNodeWithParent root)
	{
		if (root == null)
			return;

		System.out.print(root.val + "   ");
		preorder(root.left);
		preorder(root.right);
	}

	public static void postorder(TreeNodeWithParent root)
	{
		if (root == null)
			return;

		postorder(root.left);
		postorder(root.right);
		System.out.print(root.val + "   ");
	}

	public static TreeNodeWithParent createBTree(int[] values)
	{
		if (values == null || values.length == 0)
			return null;

		int index = 0;
		Queue<TreeNodeWithParent> queue = new LinkedList<TreeNodeWithParent>();
		// add into root node;
		TreeNodeWithParent root = new TreeNodeWithParent(values[index++]);
		queue.add(root);
		int levelCount = queue.size();

		// keep the current node the left or right.
		// Pop the current node before set its left/right child.
		TreeNodeWithParent cur = queue.poll();
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
				TreeNodeWithParent p = new TreeNodeWithParent(values[index]);
				if (next == Position.LEFT)
				{
					cur.left = p;
					p.parent = cur;
					next = Position.RIGHT;
					queue.offer(p);
				}
				else
				{
					cur.right = p;
					p.parent = cur;
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
