package sortedlist.bsearchtree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 */

public class Solution1
{
	public TreeNode sortedListToBST(ListNode head)
	{
		// convert the list into array.
		List<Integer> values = new ArrayList<Integer>();
		ListNode p = head;
		while (p != null)
		{
			int v = p.val;
			values.add(Integer.valueOf(v));
			p = p.next;
		}
		
		return sortListToBST(values, 0, values.size()-1);
	}
	
	private TreeNode sortListToBST(List<Integer> values, int start, int end)
	{
		if (start > end)
			return null;
		
		int middle = start + (end - start)/2;
		int v = values.get( middle);
			
		TreeNode t = new TreeNode(v);		
		
		t.left = sortListToBST(values, start, middle -1);
		t.right = sortListToBST(values, middle + 1, end);
		
		return t;
	}
}
