package leetcode.reverse.nodes.kgroup;

import leetcode.linkedlist.LinkedList;
import leetcode.linkedlist.ListNode;

public class Test
{
	private static void oneCase(ListNode head, int k)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		LinkedList.print(s1.reverseKGroup(head, k));
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		/**/

		oneCase(LinkedList.createLinkedList(new int[]
		{ 1, 2, 3, 4, 5 }), 1);

		oneCase(LinkedList.createLinkedList(new int[]
		{ 1, 2, 3, 4, 5 }), 2);

		oneCase(LinkedList.createLinkedList(new int[]
		{ 1, 2, 3, 4, 5 }), 3);

		oneCase(LinkedList.createLinkedList(new int[]
		{ 1, 2, 3, 4, 5 }), 4);

		oneCase(LinkedList.createLinkedList(new int[]
		{ 1, 2, 3, 4, 5 }), 5);

		oneCase(LinkedList.createLinkedList(new int[]
		{ 1 }), 2);

	}
}
