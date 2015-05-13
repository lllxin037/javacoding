package leetcode.remove.duplicates.sorted.listII;

import leetcode.linkedlist.ListNode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * <pre>
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * </pre>
 */

public class Solution
{
	public ListNode deleteDuplicates(ListNode head)
	{
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode pre = dummy;
		ListNode cur = head;

		while (cur != null && cur.next != null)
		{
			if (cur.next.val > cur.val)
				pre = cur;
			else
			{
				while (cur.next != null && cur.val == cur.next.val)
					cur = cur.next;

				pre.next = cur.next;
			}

			cur = cur.next;
		}

		return dummy.next;
	}
}