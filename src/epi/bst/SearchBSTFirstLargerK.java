package epi.bst;

import leetcode.btree.BTree;
import leetcode.btree.TreeNode;

public class SearchBSTFirstLargerK
{

	public static TreeNode find(TreeNode T, int key)
	{
		TreeNode[] prev = new TreeNode[1];
		return findHelper(T, prev, key);
	}

	// DFS
	private static TreeNode findHelper(TreeNode node, TreeNode[] prev, int key)
	{
		if (node == null)
			return null;

		TreeNode tmp = findHelper(node.left, prev, key);
		if (tmp != null)
			return tmp;

		if (prev[0] != null)
		{
			if (key == prev[0].val)
				return node;
			else if (key < prev[0].val)
				return null;
		}

		prev[0] = node;
		return findHelper(node.right, prev, key);
	}

	public static TreeNode findBFS(TreeNode T, int key)
	{
		if (T == null)
			return null;
		TreeNode cur = T;

		boolean foundK = false;
		TreeNode first = null;
		
		while (cur != null)
		{
			if (cur.val == key)
			{
				foundK = true;
				cur = cur.right;
			}
			else if (cur.val > key)
			{
				first = cur;
				cur = cur.left;
			}
			else
				cur = cur.right;
		}

		return foundK ? first : null;
	}

	public static void main(String[] args)
	{
		TreeNode root = BTree.createBTree(new int[]
		{ 4, 2, 5, 1, 3 });
		System.out.println(findBFS(root, 5));
		System.out.println(findBFS(root, 1).val);
		System.out.println(findBFS(root, 4).val);
		System.out.println(findBFS(root, 3).val);
	}
}
