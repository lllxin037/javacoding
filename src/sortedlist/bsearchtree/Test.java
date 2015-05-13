package sortedlist.bsearchtree;


public class Test
{

	private static void oneCase(int[] values)
	{
		System.out.println("#########################");
		Solution s = new Solution();

		ListNode head = createList(values);
		TreeNode root = s.sortedListToBST(head);
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
	
	private static ListNode createList(int[] values)
	{
		if (values == null || values.length == 0)
			return null;
		
		ListNode head = new ListNode(values[0]);
		ListNode current = head;
		for (int i = 1; i < values.length; i++)
		{
			ListNode l = new ListNode(values[i]);
			current.next = l;
			
			current = current.next;
		}
		
		return head;
		
	}
	
	public static void main(String args[])
	{
		/*oneCase(new int[]{});
		oneCase(new int[]{1});*/
		oneCase(new int[]{1,2,3});
		
		oneCase(new int[]{1,3,5, 11});
	}
}
