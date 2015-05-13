package leetcode.partition.list;

import leetcode.linkedlist.ListNode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 * 
 */

public class Solution
{
	public ListNode partition(ListNode head, int x)
	{
		ListNode newHead = new ListNode(Integer.MIN_VALUE);
		newHead.next = head;

		ListNode p = newHead;
		while (p.next != null && p.next.val < x)
			p = p.next;

		ListNode toInsert = p;
		ListNode pre = p;
		
		p = p.next;		
		while (p != null)
		{
			// move to after the toInsert;
			if (toInsert != null && p.val < x)
			{
				pre.next = p.next;
				p.next = toInsert.next;
				toInsert.next = p;

				p = pre.next;
				toInsert = toInsert.next;
			}
			else
			{
				pre = p;
				p = p.next;
			}
		}

		return newHead.next;
	}
}