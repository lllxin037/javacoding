package leetcode.merge.sorted.lists;

import leetcode.linkedlist.LinkedList;
import leetcode.linkedlist.ListNode;

public class Test
{
	private static void oneCase(int[] l1, int[] l2)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		ListNode newHead = s1.mergeTwoLists(LinkedList.createLinkedList(l1),
				LinkedList.createLinkedList(l2));
		LinkedList.print(newHead);

		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase(new int[]
		{ 0, 1, 2 }, new int[]
		{});

		oneCase(new int[]
		{ 0 }, new int[]
		{ 1 });

		oneCase(new int[]
		{ 2, 4, }, new int[]
		{ 1, 3 });

		oneCase(new int[]
		{ 2, 4, }, new int[]
		{ 1, 3, 5 });

		oneCase(new int[]
		{ 1, 3, 5 }, new int[]
		{ 2, 4 });
	}
}
