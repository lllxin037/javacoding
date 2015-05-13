package construct.btree.preAndInorder;

public class Test
{

	private static void oneCase(int[] inorder, int[] preorder)
	{
		System.out.println("#########################");
		Solution s = new Solution();

		TreeNode root = s.buildTree(inorder, preorder);
		System.out.print("pre order: ");
		preorder(root);
		System.out.println("");

		System.out.print("in order: ");
		inorder(root);
		System.out.println("");

		System.out.print("post order: ");
		postorder(root);
		System.out.println("");

		System.out.println("#########################\n\n");
	}

	private static final int NULL = Integer.MIN_VALUE;

	private static void preorder(TreeNode root)
	{
		if (root == null)
			return;

		System.out.print(root.val + "   ");
		preorder(root.left);
		preorder(root.right);
	}

	private static void inorder(TreeNode root)
	{
		if (root == null)
			return;

		inorder(root.left);
		System.out.print(root.val + "   ");
		inorder(root.right);
	}

	private static void postorder(TreeNode root)
	{
		if (root == null)
			return;

		postorder(root.left);
		postorder(root.right);
		System.out.print(root.val + "   ");
	}

	public static void main(String args[])
	{
		oneCase(new int[]
		{ 1, 2, 3, 4 }, new int[]
		{ 2, 1, 4, 3 });

		oneCase(new int[]
		{ 7, 10, 4, 3, 1, 2, 8, 11 }, new int[]
		{ 4, 10, 3, 1, 7, 11, 8, 2 });

		oneCase(new int[]
		{ 1, 2, 3 }, new int[]
		{ 2, 3, 1 });

	}
}
