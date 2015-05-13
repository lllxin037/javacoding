package epi.linkedlist;

import leetcode.linkedlist.ListNode;

public class CheckingCycle
{

	/**
	 * http://www.cnblogs.com/hiddenfox/p/3408931.html
	 * 
	 * @param head
	 * @return
	 */
	
	public static ListNode check(ListNode head)
	{
		if (head == null || head.next == null)
			return null;

		ListNode fast = head;
		ListNode slow = head;

		while (slow != null && fast != null && fast.next != null)
		{
			fast = fast.next.next;
			slow = slow.next;

			if (fast == slow)
			{
				slow = head;
				while (slow != fast)
				{
					slow = slow.next;
					fast = fast.next;
				}
				
				return slow;
			}
		}

		return null;
	}
}
