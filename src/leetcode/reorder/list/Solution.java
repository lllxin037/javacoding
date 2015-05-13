package leetcode.reorder.list;

import leetcode.reorder.list.SolutionTest.ListNode;

/**
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */

public class Solution
{
	public void reorderList(ListNode head)
	{
		if (head == null)
			return;
		
		ListNode p = head;
		int count = 0;

		while (p != null)
		{
			count++;
			p = p.next;
		}

		int middle = (count + 1) / 2;
		// split to two sub lists: 1 -- middle; middle + 1 -- end.

		p = head;
		for (int i = 0; i < middle - 1; i++)
		{
			p = p.next;
		}

		if (p == null)
			return;
		
		ListNode q = p.next;
		p.next = null;

		q = reverseList(q);
		p = head;

		// merge p and q one by one.

		ListNode current = null;

		for (int i = 0; i < middle; i++)
		{
			ListNode pNext = p.next;
			ListNode qNext = ( q == null ? null: q.next);

			if (current == null)
			{
				current = p;
			}
			else
			{
				current.next = p;
				current = current.next;
			}
			
			current.next = q;
			current = current.next;
			
			p = pNext;
			q = qNext;
		}

	}

	private static ListNode reverseList(ListNode head)
	{
		if (head == null)
			return null;

		ListNode emptyNode = new ListNode(0);
		ListNode p = head;

		while (p != null)
		{
			ListNode next = p.next;

			ListNode q = emptyNode.next;
			emptyNode.next = p;
			p.next = q;

			p = next;
		}

		return emptyNode.next;
	}
}