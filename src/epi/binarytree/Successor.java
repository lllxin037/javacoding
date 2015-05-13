package epi.binarytree;

/**
 * Design an algorithm that takes a node n in a binary tree, and returns its
 * successor. Assume that each node has a parent field; the parent field of root
 * is null.
 * 
 * Inorder traversal.
 * 
 */

public class Successor
{

	public static TreeNodeWithParent retrieve(TreeNodeWithParent node)
	{
		if (node == null)
			return null;

		// if the node is leaf and left node, return parent;

		TreeNodeWithParent cur = node;

		if (cur.right != null)
		{
			cur = node.right;
			while (cur.left != null)
				cur = cur.left;

			return cur;
		}

		// go back to parent. node's parent is some nodes's left.
		while (cur.parent != null && cur.parent.right == cur)
		{
			cur = cur.parent;
		}

		return cur.parent;
	}

	/**
	 * Test tree inorder:
	 * 
	 * <pre>
	 * 2, 7, 4 , 1, 10, 9, 3, 11
	 * </pre>
	 * 
	 */

	public static void main(String[] args)
	{
		TreeNodeWithParent root = BTreeWithParent.createBTree(new int[]
		{ 1, 2, 3, BTreeWithParent.NULL, 4, 10, 11, 7, BTreeWithParent.NULL,
				BTreeWithParent.NULL, 9 });

		System.out.println(retrieve(root.left.right.left).val); // 7's successor
		System.out.println(retrieve(root.left.right).val); // 4's successor

		System.out.println(retrieve(root.right.left).val); // 10's successor
		System.out.println(retrieve(root.right.left.right).val); // 9's successor

		System.out.println(retrieve(root.right.right)); // 11's successor
	}
}
