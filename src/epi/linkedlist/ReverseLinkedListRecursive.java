package epi.linkedlist;

import leetcode.linkedlist.LinkedList;
import leetcode.linkedlist.ListNode;

public class ReverseLinkedListRecursive
{

	public static ListNode reverse(ListNode head)
	{
		if (head.next == null)
			return head;

		ListNode newNode = reverse(head.next);
		head.next.next = head;
		head.next = null;

		return newNode;
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
