package leetcode.recover.bsearchtree;

import java.util.ArrayList;
import java.util.List;

import leetcode.btree.TreeNode;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure. Note: A solution using O(n)
 * space is pretty straight forward. Could you devise a constant space solution?
 * 
 */

public class Solution0
{
	public void recoverTree(TreeNode root)
	{
		if (root == null)
			return;

		TreeNode[] lastNode = new TreeNode[1];

		// the max errors will be in two pairs. 8 nodes are enough
		List<TreeNode> errorNode = new ArrayList<TreeNode>();

		checkErrorNodes(root, lastNode, errorNode);

		correctErrorNodes(errorNode);
	}

	private void correctErrorNodes(List<TreeNode> errorNode)
	{
		if (errorNode.size() == 2)
		{
			int value = errorNode.get(0).val;
			errorNode.get(0).val = errorNode.get(1).val;
			errorNode.get(1).val = value;

			return;
		}

		if (errorNode.size() == 3)
		{
			TreeNode a = errorNode.get(0);
			TreeNode c = errorNode.get(2);

			// switch a & c
			int value = c.val;
			c.val = a.val;
			a.val = value;

			return;
		}

		if (errorNode.size() == 4)
		{
			TreeNode a = errorNode.get(0);
			TreeNode c = errorNode.get(3);

			// switch a & c
			int value = c.val;
			c.val = a.val;
			a.val = value;

			return;
		}
	}

	private void checkErrorNodes(TreeNode p, TreeNode[] lastNode,
			List<TreeNode> errorNode)
	{
		if (p == null)
			return;

		checkErrorNodes(p.left, lastNode, errorNode);

		if (p.left == null && p.right == null && lastNode[0] == null)
		{
			lastNode[0] = p;
			return;
		}

		if (lastNode[0] == null)
		{
			lastNode[0] = p;

			checkErrorNodes(p.right, lastNode, errorNode);
			return;
		}

		if (p.val < lastNode[0].val)
		{
			TreeNode lastError = null;
			if (!errorNode.isEmpty())
				lastError = errorNode.get(errorNode.size() - 1);

			if (lastError == null || lastError != lastNode[0])
			{
				errorNode.add(lastNode[0]);
				errorNode.add(p);
			}
			else if (lastError == lastNode[0])
			{
				errorNode.add(p);
			}
		}

		lastNode[0] = p;
		checkErrorNodes(p.right, lastNode, errorNode);
	}
}
