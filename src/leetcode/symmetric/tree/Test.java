package leetcode.symmetric.tree;



public class Test
{

	private static void oneCase(int[] values)
	{
		System.out.println("#########################");
		Solution s = new Solution();

		TreeNode root = createBTree(values, 0);
		System.out.println( s.isSymmetric(root) );
	
		System.out.println("#########################\n\n");
	}
	
	private static final int NULL = Integer.MIN_VALUE;
	
	private static TreeNode createBTree(int[] values, int startIndex)
	{
		if (startIndex >= values.length)
			return null;
		
		int v = values[startIndex];
		if (v == NULL)
			return null;
		
		TreeNode newNode = new TreeNode(v);
		newNode.left = createBTree(values, 2*startIndex + 1);
		newNode.right = createBTree(values, 2*startIndex + 2);
		
		return newNode;
	}
	
	public static void main(String args[])
	{
		oneCase( new int[]{1, 2, 2});
		oneCase( new int[]{1, 2, 1});
		
		oneCase( new int[]{1, 2, 2, 3, 4, 4, 3});
		oneCase( new int[]{1, 2, 2, NULL, 3, NULL, 3});
		
		oneCase( new int[]{1, 2, 2, 3, NULL, NULL, 3});
		
		oneCase( new int[]{1,2,3,3,NULL,2,NULL});
	}
}
