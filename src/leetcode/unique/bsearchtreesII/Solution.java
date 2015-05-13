package leetcode.unique.bsearchtreesII;

import java.util.ArrayList;

import leetcode.btree.TreeNode;

/**
 * Given n, generate all structurally unique BST's (binary search trees) that
 * store values 1...n.
 * 
 * <pre>
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 * 
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * </pre>
 */

public class Solution
{
	public ArrayList<TreeNode> generateTrees(int n)
	{
		return doGenerateTrees(1, n);
	}

	private ArrayList<TreeNode> doGenerateTrees(int start, int end)
	{
		ArrayList<TreeNode> trees = new ArrayList<TreeNode>();
		if (start > end)
		{
			trees.add(null);
			return trees;
		}

		for (int i = start; i <= end; i++)
		{
			ArrayList<TreeNode> leftTrees = doGenerateTrees(start, i - 1);
			ArrayList<TreeNode> rightTrees = doGenerateTrees(i + 1, end);
			for (TreeNode left : leftTrees)
			{
				for (TreeNode right : rightTrees)
				{
					TreeNode root = new TreeNode(i);
					root.left = left;
					root.right = right;
					trees.add(root);
				}
			}
		}

		return trees;
	}
}
