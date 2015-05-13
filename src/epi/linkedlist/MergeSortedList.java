package epi.linkedlist;

import leetcode.linkedlist.LinkedList;
import leetcode.linkedlist.ListNode;

/**
 * 
 *
 */

public class MergeSortedList
{

	public static ListNode merge(ListNode l, ListNode f)
	{
		if (l == null)
			return f;
		if (f == null)
			return l;

		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;

		while (l != null || f != null)
		{
			if (l == null || (f != null && f.val < l.val))
			{
				cur.next = f;
				f = f.next;
			}
			else
			{
				cur.next = l;
				l = l.next;
			}

			cur = cur.next;
		}

		return dummy.next;
	}

	public static void main(String[] args)
	{
		LinkedList.print(merge(LinkedList.createLinkedList(new int[]
		{ 2, 5, 7 }), LinkedList.createLinkedList(new int[]
		{ 3, 11 })));
	}
}
