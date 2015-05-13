package leetcode.insertionsortlist;

import leetcode.insertionsortlist.SolutionTest.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution
{
	public ListNode insertionSortList(ListNode head)
	{
		if (head == null)
			return null;
		
		ListNode p, q;
		ListNode newHead = head;
		p = q = head;


		ListNode sortedTail = head;
		ListNode unsorted = head.next;
		
		while (sortedTail.next != null)
		{
			p = newHead;
			q = unsorted;
			
			unsorted = q.next;
		
			sortedTail.next = null;
			
			// append to the tail
			if (q.val >= sortedTail.val)
			{
				sortedTail.next = q; 
				sortedTail = q; 
			}
			else
			// append to the head
			if (q.val <= newHead.val)
			{
				q.next = newHead;
				newHead = q;				
			}
			else
			{
				// must in the middle	
				while ( p.next != null)
				{				
					if ( q.val <= p.next.val )
					{
						q.next = p.next;
						p.next = q;
						break;
					}
					
					p = p.next;
				} 
			}
				
			sortedTail.next = unsorted;
		}
		
		return newHead;
	}

}