package leetcode.recover.bsearchtree;

import leetcode.btree.TreeNode;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure. Note: A solution using O(n)
 * space is pretty straight forward. Could you devise a constant space solution?
 * 
 */

public class Solution
{
	public void recoverTree(TreeNode root)
	{
		if (root == null)
			return;

		// the max errors will be in two pairs. 8 nodes are enough
		TreeNode[] errorNode = new TreeNode[2];

		inorderMorris(root, errorNode);
		correctErrorNodes(errorNode);
	}

	private void correctErrorNodes(TreeNode[] errorNode)
	{
		int value = errorNode[0].val;
		errorNode[0].val = errorNode[1].val;
		errorNode[1].val = value;
	}

	private void inorderMorris(TreeNode root, TreeNode[] errorNode)
	{
		TreeNode cur = root;
		TreeNode pre = null;
		
		while (cur != null)
		{
			if (cur.left != null)
			{
				TreeNode p = cur.left;
				while (p.right != null && p.right != cur)
				{
					p = p.right;
				}
				if (p.right == null)
				{ // set right to successor
					p.right = cur;
					cur = cur.left;
				}
				else
				{ // visit and revert the change
					p.right = null;
					
					// check pre and current here.
					
					if ( pre != null && cur.val < pre.val)
					{
						errorNode[1] = cur;
						if (errorNode[0] == null)
						{
							errorNode[0] = pre;
						}
					}	
					pre = cur;
					cur = cur.right;					
				}
			}
			else
			{ 
				// visit and move to successor
				
				if ( pre != null && cur.val < pre.val)
				{
					errorNode[1] = cur;
					if (errorNode[0] == null)
					{
						errorNode[0] = pre;
					}
				}					
				
				pre = cur;
				cur = cur.right;				
			}
		}
	}
}
