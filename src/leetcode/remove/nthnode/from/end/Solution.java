package leetcode.remove.nthnode.from.end;

import leetcode.linkedlist.ListNode;

/**
 * Given a linked list, remove the nth node from the end of list and return its
 * head.
 * 
 * <pre>
 * For example,
 * 
 *    Given linked list: 1->2->3->4->5, and n = 2.
 * 
 *    After removing the second node from the end, the linked list becomes 1->2->3->5.
 * </pre>
 * 
 * Note: Given n will always be valid. Try to do this in one pass.
 * 
 */

public class Solution
{
	public ListNode removeNthFromEnd(ListNode head, int n)
	{
		if (head == null)
			return null;

		ListNode newHead = new ListNode(0);
		newHead.next = head;

		ListNode fast = head;
		ListNode slow = newHead;

		int count = 1;
		while (fast != null && count++ < n)
			fast = fast.next;

		while (fast.next != null)
		{
			fast = fast.next;
			slow = slow.next;
		}

		// remove the element
		slow.next = slow.next.next;

		return newHead.next;
	}
}