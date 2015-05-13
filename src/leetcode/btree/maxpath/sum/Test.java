package leetcode.btree.maxpath.sum;

import leetcode.btree.TreeNode;


public class Test
{
	private static final int NULL = Integer.MIN_VALUE;
	
	public static TreeNode build(int[] array, int i)
	{
		if (i >= array.length)
			return null; // nothing to build

		if (array[i] == NULL)
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
		System.out.println(s.maxPathSum(root));
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
				{ -2, 1 });
		oneCase(new int[]
		{ 1, -1, 3 });
		oneCase(new int[]
		{ 1, 2, 3 });
		
		oneCase(new int[]
		{ 4, 9, 0, NULL, 1 });
		
		oneCase(new int[]
		{ 1, 2, 4, NULL, NULL, 5, NULL });
		
		oneCase(new int[] {1,-2,-3,1,3,-2, NULL,-1} );
		
		oneCase(new int[] {5,4,8,11,NULL,13,4,7,2,NULL,NULL,NULL,1} );
		
		oneCase(new int[] {-1,-2,-3} );
		
		/*oneCase(new int[]
		{ 5, 3, 8, 0, 1, 3, -1, 1, 8, 4, 4, 2, 3, -1, -1, -1, -1, 5, 4, -1, -1,
				7, -1, -1, 6, -1, -1, -1, 1, -1, 6, -1, -1, -1, -1, 8, -1, 7 }); */
	}
	
}
