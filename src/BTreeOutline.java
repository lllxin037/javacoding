import java.util.Stack;

import leetcode.btree.BTree;
import leetcode.btree.TreeNode;

/**
 * Given a complete binary tree, print the outline of the tree in anti-clockwise
 * direction, starting from the root. I.e. first print all the nodes on the left
 * edge of the tree going downwards, then print all the leaves going left to
 * right (including leaves on both the last and the 2nd last level if
 * necessary), then print the nodes on the right edge of the tree going upwards.
 * 
 * <pre>
 * Example tree:
 *       A
 *      /   \
 * 	   B     C
 * 	  / \   / \
 *   D   E  F   G
 *  / \ /
 *  H I J
 * 
 * Expected Output: ABDHIJFGC
 * </pre>
 * 
 */

public class BTreeOutline
{
	private static void printLeftAndBottom(TreeNode root, boolean print)
	{
		if (root == null)
			return;

		if (print || (root.left == null && root.right == null))
			System.out.print(root.val + " ");

		printLeftAndBottom(root.left, print);
		printLeftAndBottom(root.right, false);
	}

	public static void printOutline(TreeNode root, boolean print)
	{
		printLeftAndBottom(root, print);

		if (root == null)
			return;

		Stack<TreeNode> stack = new Stack<TreeNode>();

		TreeNode rightMost = root.right;
		while (rightMost != null && rightMost.right != null)
		{
			stack.push(rightMost);
			rightMost = rightMost.right;
		}
		System.out.print(stack.pop().val + " ");
	}

	public static void main(String[] args)
	{
		TreeNode root = BTree.createBTree(new int[]
		{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
		printOutline(root, true);
	}

}
