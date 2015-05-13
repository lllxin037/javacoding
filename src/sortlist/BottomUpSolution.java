package sortlist;

import leetcode.linkedlist.ListNode;

/**
 * <pre>
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 * </pre>
 * 
 *  O(n log n) 
 */

/**
 * Uses merge sort algorithm to sort on linked list.
 * 
 */

public class BottomUpSolution
{
	public ListNode sortList(ListNode head)
	{
		if (head == null)
			return null;

		int psize = 0;
		ListNode p = head;
		while (p != null)
		{
			psize++;
			p = p.next;
		}

		p = head;
		ListNode q = p;

		for (int width = 1; width < psize; width = 2 * width)
		{
			ListNode remain = head;
			ListNode newStepHead = null;
			
			p = q = remain;
			
			for (int i = 0; i < psize; i = i + 2 * width)
			{				
				p = q = remain;

				// adjust q
				for (int j = 0; (j < width -1) && (q != null); j++)
				{
					q = q.next;
				}

				if ( q == null)
					break;
				
				ListNode t = q;
				q = t.next;
				t.next = null;
				

				if ( q == null)
					break;
				
				// get the remain
				remain = q;
				for (int j = 0; (j < width -1) && (remain != null); j++)
				{
					remain = remain.next;
				}
				
				if (remain != null)
				{
					t = remain;
					remain = t.next;
					t.next = null;
				}

				if (newStepHead == null)
				{
					head = mergeOneStep(p, q, width);
					newStepHead = head;
				}
				else
				{
					newStepHead = mergeOneStep(p, q, width);

					// move to the end of head then append new step

					ListNode last = head;
					while (last.next != null)
					{
						last = last.next;
					}
					
					last.next = newStepHead;
				}
			}

			if (remain != null)
			{
				ListNode last = head;
				while (last.next != null)
				{
					last = last.next;
				}
				
				last.next = remain;
			}
		}

		
		return head;
	}

	private ListNode mergeOneStep(ListNode p, ListNode q, int step)
	{
		ListNode stepHead = null;
		ListNode current = null;

		while ( (q!=null) && (p!= null) )
		{
			if (p.val <= q.val)
			{
				if (stepHead == null)
					stepHead = current = p;
				else
				{
					current.next = p;
					current = p;
				}
				p = p.next;
			}
			else
			{
				if (stepHead == null)
					stepHead = current = q;
				else
				{
					current.next = q;
					current = q;
				}
				q = q.next;
			}
		}

		if (p != null)
			current.next = p;
		if (q != null)
			current.next = q;

		return stepHead;
	}
}