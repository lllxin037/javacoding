package leetcode.btree.search.tree.iterator;

import leetcode.btree.BTree;
import leetcode.btree.TreeNode;

public class Test
{

	private static void iterateTree(TreeNode root)
	{
		BSTIterator i = new BSTIterator(root);
		while (i.hasNext())
			System.out.print(i.next() + "    ");
		System.out.println();
	}

	public static void main(String[] args)
	{
		
		iterateTree(BTree.createBTree(new int[]{6, 4, 12, 3, 5, 9}));
		
		iterateTree(BTree.createBTree(new int[]{6, 4, 12, BTree.NULL, 5, 9}));
	}
}
