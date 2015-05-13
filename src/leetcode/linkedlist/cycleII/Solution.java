package leetcode.linkedlist.cycleII;

import leetcode.linkedlist.ListNode;

/**
 * Definition for singly-linked list.
 * 
 * The cycle could happen anywhere.
 */

public class Solution
{
	public ListNode detectCycle(ListNode head)
	{
		if (head == null || head.next == null)
			return null;

		ListNode slow = head;
		ListNode fast = head;

		while (slow != null && fast != null)
		{			
			slow = slow.next;
			fast = fast.next;
			if (fast != null)
				fast = fast.next;
			
			if (slow == fast )
				break;
		}

		if (slow == null || fast == null)
			return null;
		
		// must have a cycle 
		slow = head;
		while (slow != fast)
		{
			slow = slow.next;
			fast = fast.next;
		}

		return slow;
	}
}

// public class Solution
// {
// public static ListNode detectCycle(ListNode head)
// {
// ListNode slow = head;
// ListNode fast = head;
//
// while (true)
// {
// if (fast == null || fast.next == null)
// {
// return null;
// }
// slow = slow.next;
// fast = fast.next.next;
// if (fast == slow)
// {
// break;
// }
// }
//
// slow = head;
// while (slow != fast)
// {
// slow = slow.next;
// fast = fast.next;
// }
// return slow;
// }
// }
