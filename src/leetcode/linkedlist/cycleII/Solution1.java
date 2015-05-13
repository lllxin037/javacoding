package leetcode.linkedlist.cycleII;

import leetcode.linkedlist.ListNode;

/**
 * Definition for singly-linked list.
 * 
 * The cycle could happen anywhere.
 */

public class Solution1
{
	public ListNode detectCycle(ListNode head)
	{

		ListNode fast = head;
		ListNode slow = head;

		while (fast != null && fast.next != null)
		{
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow)
				break;
		}

		if (fast == null || fast.next == null)
			return null;

		fast = head;
		while (fast != slow)
		{
			fast = fast.next;
			slow = slow.next;
		}

		return fast;
	}
}
