package sortedarray.bsearchtree;


public class Test
{

	private static void oneCase(int[] values)
	{
		System.out.println("#########################");
		Solution s = new Solution();

		TreeNode root = s.sortedArrayToBST(values);
		visitTree(root);
		
		System.out.println("\n#########################\n\n");
	}
	
	private static void visitTree(TreeNode root)
	{
		if (root == null)
			return;
		
		visitTree(root.left);
		System.out.print( root.val + "    " );
		visitTree(root.right);
	}
	
	public static void main(String args[])
	{
		oneCase(new int[]{});
		oneCase(new int[]{1});
		oneCase(new int[]{1,2,3});
		
		oneCase(new int[]{1,3,5, 11});
	}
}
