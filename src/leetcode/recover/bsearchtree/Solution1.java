package leetcode.recover.bsearchtree;

import leetcode.btree.TreeNode;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure. Note: A solution using O(n)
 * space is pretty straight forward. Could you devise a constant space solution?
 * 
 */

public class Solution1
{
	public void recoverTree(TreeNode root)
	{
		if (root == null)
			return;

		// the max errors will be in two pairs. 8 nodes are enough
		TreeNode[] errorNode = new TreeNode[2];

		checkErrorNodes(root, errorNode, null);
		correctErrorNodes(errorNode);
	}

	private void correctErrorNodes(TreeNode[] errorNode)
	{
		int value = errorNode[0].val;
		errorNode[0].val = errorNode[1].val;
		errorNode[1].val = value;
	}

	private TreeNode checkErrorNodes(TreeNode p, TreeNode[] errorNode,
			TreeNode pre)
	{
		if (p == null)
			return pre;

		TreeNode last = checkErrorNodes(p.left, errorNode, pre);

		if (last != null && p.val < last.val)
		{
			errorNode[1] = p;
			if (errorNode[0] == null)
			{
				errorNode[0] = last;
			}
			else
				return p;
		}

		return checkErrorNodes(p.right, errorNode, p);
	}
}
