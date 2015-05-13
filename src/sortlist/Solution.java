package sortlist;

import leetcode.linkedlist.ListNode;

/**
 * <pre>
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 * </pre>
 * 
 *  O(n log n) 
 */

/**
 * Uses merge sort algorithm to sort on linked list.
 * 
 */

public class Solution
{
	public ListNode sortList(ListNode head)
	{
		if (head == null || head.next == null)
			return head;

		ListNode p = getMid(head);
		ListNode q = p.next;

		p.next = null;
		p = head;

		p = sortList(p);
		q = sortList(q);
		return mergeList(p, q);
	}

	private ListNode getMid(ListNode head)
	{
		ListNode p = head;
		ListNode q = head;
		while (p.next != null && q.next != null && q.next.next != null)
		{
			p = p.next;
			q = q.next.next;
		}
		return p;
	}

	private ListNode mergeList(ListNode p, ListNode q)
	{
		ListNode dummy = new ListNode(0);
		ListNode current = dummy;

		while (p != null || q != null)
		{
			if (q == null || (p != null && p.val <= q.val))
			{
				current.next = p;
				current = p;
				p = p.next;
			}
			else
			{
				current.next = q;
				current = q;
				q = q.next;
			}
		}

		return dummy.next;
	}
}