package swap.nodes.pairs;

import leetcode.linkedlist.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values
 * in the list, only nodes itself can be changed.
 * 
 */
public class Solution
{
	public ListNode swapPairs(ListNode head)
	{
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;

		ListNode p = dummyHead;
		
		// 1->2->3->4
		while (p.next != null && p.next.next != null)
		{
			// tmp = 1;
			ListNode tmp = p.next;
			
			// dummy -> 2
			p.next = p.next.next;
			// p = 2;
			p = p.next;
			
			// 1 -> 3
			tmp.next = p.next;
			// 2 -> 1
			p.next = tmp;
			
			// p = 1;
			p = p.next;			
		}

		return dummyHead.next;

	}
}