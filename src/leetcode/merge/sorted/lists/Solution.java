package leetcode.merge.sorted.lists;

import leetcode.linkedlist.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 */

public class Solution
{
	public ListNode mergeTwoLists(ListNode l1, ListNode l2)
	{
		ListNode head = new ListNode(0);

		ListNode current = head;

		ListNode p = l1;
		ListNode q = l2;

		while (p != null || q != null)
		{
			if (p == null || (q != null && q.val <= p.val))
			{
				current.next = q;
				q = q.next;
			}
			else
			{
				current.next = p;
				p = p.next;
			}

			current = current.next;
		}

		return head.next;
	}
}