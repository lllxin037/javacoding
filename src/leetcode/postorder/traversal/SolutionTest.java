package leetcode.postorder.traversal;

public class SolutionTest
{
	static class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x)
		{
			val = x;
		}
	}

	static class CreateTree
	{
		private int[] values;
		private int count;

		CreateTree(int[] values)
		{
			this.values = values;
			count = 0;
		}

		TreeNode getRoot()
		{
			return createBinaryTree();
		}

		private TreeNode createBinaryTree()
		{
			TreeNode t;

			// end
			if (count == values.length)
				return null;

			// empty node
			if (values[count++] == NULL)
			{
				t = null;
			}
			else
			{
				t = new TreeNode(values[count - 1]);
				t.left = createBinaryTree();
				t.right = createBinaryTree();
			}
			return t;
		}

	}

	private static final int NULL = Integer.MIN_VALUE;

	public static void main(String args[])
	{
		Solution sol = new Solution();

		// use MIN_VALUE to indicate NULL
		int[] tokens1 =
		{ 1, NULL, 2, 3 };

		TreeNode root = new CreateTree(tokens1).getRoot();
		System.out.println(sol.postorderTraversal(root));

		int[] tokens2 =
		{};
		root = new CreateTree(tokens2).getRoot();
		System.out.println(sol.postorderTraversal(root));

		int[] tokens3 =
		{ 1, 2, 3, 5, 8, 9 };
		root = new CreateTree(tokens3).getRoot();
		System.out.println(sol.postorderTraversal(root));

		int[] tokens4 =
		{ 1, 8, 3, NULL, 7, 9 };
		root = new CreateTree(tokens4).getRoot();
		System.out.println(sol.postorderTraversal(root));

		return;
	}
}
