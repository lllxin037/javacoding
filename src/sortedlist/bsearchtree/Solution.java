package sortedlist.bsearchtree;


/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 */

public class Solution
{
	public TreeNode sortedListToBST(ListNode head)
	{
		// convert the list into array.

		int len = 0;
		ListNode p = head;
		while (p != null)
		{
			len++;
			p = p.next;
		}

		ListNode[] args = new ListNode[1];
		args[0] = head;
		return sortListToBST(args, 0, len - 1);
	}

	private TreeNode sortListToBST(ListNode[] args, int start, int end)
	{
		if (start > end)
			return null;

		int middle = start + (end - start) / 2;
		TreeNode left = sortListToBST(args, start, middle - 1);
		
		ListNode p = args[0];
		TreeNode parent = new TreeNode(p.val);
		parent.left = left;

		args[0] = p.next;		
		parent.right = sortListToBST(args, middle + 1, end);

		return parent;
	}
}
