package leetcode.rotate.list;

import leetcode.linkedlist.ListNode;

/**
 * Given a list, rotate the list to the right by k places, where k is
 * non-negative.
 * 
 * <pre>
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * </pre>
 * 
 */

public class Solution
{
	public ListNode rotateRight(ListNode head, int n)
	{
		if (head == null || n == 0 || head.next == null)
			return head;

		ListNode pre = head;
		ListNode end = head;

		while (end.next != head || n > 0)
		{
			if (n > 0)
				n--;
			else
				pre = pre.next;

			end = end.next;

			if (end.next == null)
				end.next = head;
		}

		ListNode newHead = pre.next;
		pre.next = null;

		return newHead;

	}
}
