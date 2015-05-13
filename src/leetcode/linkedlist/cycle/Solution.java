package leetcode.linkedlist.cycle;

import leetcode.linkedlist.cycle.SolutionTest.ListNode;

/**
 * Definition for singly-linked list.
 * 
 * The cycle could happen anywhere.
 */
public class Solution
{
	public boolean hasCycle(ListNode head)
	{
		if (head == null || head.next == null)
			return false;

		ListNode p = head;	
		ListNode q = head.next.next;
		
		while (p != null && q!= null)
		{
			if ( p == q)
				return true;
			
			p = p.next;
			
			if (q.next == null)
				break;
			else
				q = q.next.next;
		}

		return false;
	}
}