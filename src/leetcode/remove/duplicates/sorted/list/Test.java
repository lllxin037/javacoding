package leetcode.remove.duplicates.sorted.list;

import leetcode.linkedlist.LinkedList;
import leetcode.linkedlist.ListNode;

public class Test
{
	private static void oneCase(int[] values)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		ListNode head = s1
				.deleteDuplicates(LinkedList.createLinkedList(values));
		LinkedList.print(head);

		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase(null);
		oneCase(new int[]
		{});

		oneCase(new int[]
		{ 1 });

		oneCase(new int[]
		{ 1, 1, 2 });
		oneCase(new int[]
		{ 1, 1, 2, 3, 3 });

	}
}
