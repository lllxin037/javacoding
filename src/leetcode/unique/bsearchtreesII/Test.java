package leetcode.unique.bsearchtreesII;

import java.util.ArrayList;

import leetcode.btree.BTree;
import leetcode.btree.TreeNode;

public class Test
{
	private static void oneCase(int n)
	{
		System.out.println("#########################");
		Solution s = new Solution();
		
		ArrayList<TreeNode> trees = s.generateTrees(n);
		for (int i = 0; i < trees.size(); i++)
		{
			TreeNode root = trees.get(i);
			BTree.inorder(root);
			System.out.println();
		}
		System.out.println("#########################\n\n");
	}

	public static void main(String[] args)
	{
		oneCase(0);
		
		oneCase(3);
	}
}
