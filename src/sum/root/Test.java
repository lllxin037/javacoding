package sum.root;

public class Test
{

	public static TreeNode build(int[] array, int i)
	{
		if (i >= array.length)
			return null; // nothing to build

		if (array[i] == -1)
		{
			return null;
		}

		TreeNode node = new TreeNode(array[i]); // new node for array[i]

		node.left = build(array, 2 * i + 1); // build left sub-tree
		node.right = build(array, 2 * i + 2); // build right sub-tree

		return node;
	}

	private static void oneCase(int[] array)
	{
		System.out.println("***************************");
		TreeNode root = build(array, 0);
		Solution s = new Solution();
		System.out.println(s.sumNumbers(root));
		System.out.println("****************************");
	}

	public static void main(String[] args)
	{
		oneCase(new int[]
		{});
		oneCase(new int[]
		{ 1 });
		oneCase(new int[]
		{ 1, 0 });
		oneCase(new int[]
		{ 1, -1, 3 });
		oneCase(new int[]
		{ 1, 2, 3 });

		oneCase(new int[]
		{ 4, 9, 0, -1, 1 });
		oneCase(new int[]
		{ 1, 2, 4, -1, -1, 5, -1 });
		oneCase(new int[]
		{ 5, 3, 8, 0, 1, 3, -1, 1, 8, 4, 4, 2, 3, -1, -1, -1, -1, 5, 4, -1, -1,
				7, -1, -1, 6, -1, -1, -1, 1, -1, 6, -1, -1, -1, -1, 8, -1, 7 });
	}

}
