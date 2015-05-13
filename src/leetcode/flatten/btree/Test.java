package leetcode.flatten.btree;


public class Test
{

	private static void oneCase(int[] values)
	{
		System.out.println("#########################");
		Solution s = new Solution();

		TreeNode root = createBTree(values, 0);
		s.flatten(root);
		
		TreeNode p = root;
		while (p != null)
		{
			System.out.print( p.val + "   ");
			p = p.right;
		}
		System.out.println("");
		
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
		oneCase(new int[]{1,NULL,2});
		oneCase(new int[]{1,2,5,3,4,NULL,6});
		oneCase(new int[]{1,2,5,3,4,NULL,6,NULL,NULL,7});
	}
}
