package leetcode.remove.duplicates.sorted.list;

import leetcode.linkedlist.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * <pre>
 * For example, 
 * Given 1->1->2, return 1->2. 
 * Given 1->1->2->3->3, return 1->2->3.
 * </pre>
 */

public class Solution
{
	public ListNode deleteDuplicates(ListNode head)
	{
		ListNode pre = null;
		ListNode cur = head;

		while (cur != null)
		{
			if (pre == null || cur.val > pre.val)
			{
				pre = cur;
				cur = cur.next;
				continue;
			}

			pre.next = cur.next;
			cur = cur.next;
		}

		return head;
	}
}