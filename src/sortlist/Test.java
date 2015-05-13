package sortlist;

import leetcode.linkedlist.LinkedList;
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

public class Test
{

	static void oneCase(int[] arrays)
	{
		Solution s1 = new Solution();
		ListNode head = s1.sortList(LinkedList.createLinkedList(arrays));

		System.out.println("#############################");
		LinkedList.print(head);
		System.out.println("#############################\n\n\n");
	}

	public static void main(String args[])
	{
		oneCase(new int[]
		{ 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 100, 20, 11 });

		oneCase(new int[]
		{ 0, 9, 3, 150, 6, 7, 4, 2, 1, 8 });
	}
}