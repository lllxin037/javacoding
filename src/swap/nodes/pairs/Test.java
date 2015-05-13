package swap.nodes.pairs;

import leetcode.linkedlist.LinkedList;
import leetcode.linkedlist.ListNode;

public class Test
{
	private static void oneCase(ListNode head)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		LinkedList.print(s1.swapPairs(head));
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		/**/

		oneCase(LinkedList.createLinkedList(new int[]
		{ 1, 2, 3, 4, 5 }));

		oneCase(LinkedList.createLinkedList(new int[]
		{ 1, 2, 3, 4 }));

		oneCase(LinkedList.createLinkedList(new int[]
		{ 1, 2, 3 }));

		oneCase(LinkedList.createLinkedList(new int[]
		{ 1, 2 }));
		
		oneCase(LinkedList.createLinkedList(new int[]
		{ 1 }));

	}
}
