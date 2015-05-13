package epi.bst;

import leetcode.btree.BTree;
import leetcode.btree.TreeNode;

public class BuildBST
{
	public static TreeNode create(int[] A)
	{
		return createHelper(A, 0, A.length - 1);
	}

	private static TreeNode createHelper(int[] A, int start, int end)
	{
		if (start > end)
			return null;

		int mid = start + ((end - start) >> 1);
		TreeNode left = createHelper(A, start, mid - 1);
		TreeNode root = new TreeNode(A[mid]);
		TreeNode right = createHelper(A, mid + 1, end);
		root.left = left;
		root.right = right;

		return root;
	}

	public static void main(String[] args)
	{
		int[] test = new int[]
		{ 2, 3, 5, 7, 10, 11 };
		TreeNode root = create(test);
		BTree.inorder(root);
	}
}
