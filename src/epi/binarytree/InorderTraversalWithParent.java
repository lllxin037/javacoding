package epi.binarytree;

/**
 * Let T be the root of a binary tree in which nodes have an explicit parent
 * field. Design an iterative algorithm that enumerates the nodes inorder and
 * uses O(1) additional space. Your algorithm cannot modify the tree.
 * 
 */

public class InorderTraversalWithParent
{

	public static void traverse(TreeNodeWithParent root)
	{
		if (root == null)
			return;

		// goes to the left end then back

		TreeNodeWithParent cur = root;
		TreeNodeWithParent pre = null, next = null;

		while (cur != null)
		{
			if (pre == null || pre.right == cur || pre.left == cur) // handle
																	// left
																	// subtree.
			{
				if (cur.left == null)
				{
					System.out.print(cur.val + "   ");

					if (cur.right != null)
						next = cur.right;
					else
						next = cur.parent;
				}
				else
				{
					next = cur.left;
				}
			}
			else if (pre == cur.left) // handle right subtree.
			{
				System.out.print(cur.val + "   ");
				if (cur.right != null)
					next = cur.right;
				else
					next = cur.parent;
			}
			else if (pre == cur.right) // finish the subtree that cur is the
										// root node
			{
				next = cur.parent;
			}

			pre = cur;
			cur = next;
		}
		System.out.println();
	}

	public static void main(String[] args)
	{
		TreeNodeWithParent root = BTreeWithParent.createBTree(new int[]
		{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, BTreeWithParent.NULL,
				BTreeWithParent.NULL, 14, 15 });

		traverse(root);
		
		BTreeWithParent.inorder(root);
	}
}
