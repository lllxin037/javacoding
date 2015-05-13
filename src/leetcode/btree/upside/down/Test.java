package leetcode.btree.upside.down;

import leetcode.btree.BTree;
import leetcode.btree.TreeNode;

public class Test
{
	private static void oneCase(int[] array)
	{
		System.out.println("***************************");
		TreeNode root = BTree.createBTree(array);
		Solution s = new Solution();
		BTree.levelOrder(s.upsideDownBinaryTree(root));
		System.out.println("\n****************************");
	}

	public static void main(String[] args)
	{
		oneCase(new int[]
		{ 1, 2, 3 });

		oneCase(new int[]
		{ 1, 2, 3, 4, 5 });

	}

}
