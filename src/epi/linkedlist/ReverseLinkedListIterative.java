package epi.linkedlist;

import leetcode.linkedlist.LinkedList;
import leetcode.linkedlist.ListNode;

public class ReverseLinkedListIterative
{
	public static ListNode reverse(ListNode head)
	{
		if (head.next == null)
			return head;

		ListNode pre = null;
		ListNode p = head;
		while (p != null)
		{
			ListNode cur = p;
			p = p.next;

			cur.next = pre;
			pre = cur;
		}

		return pre;
	}

	public static void main(String[] args)
	{
		LinkedList.print(reverse(LinkedList.createLinkedList(new int[]
		{ 3, 6, 5 })));

		LinkedList.print(reverse(LinkedList.createLinkedList(new int[]
		{ 3, 5 })));

		LinkedList.print(reverse(LinkedList.createLinkedList(new int[]
		{ 1, 2, 3, 5 })));
	}
}
