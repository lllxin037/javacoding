package leetcode.merge.ksorted.lists;

import java.util.ArrayList;
import java.util.List;

import leetcode.linkedlist.LinkedList;
import leetcode.linkedlist.ListNode;

public class Test
{
	private static List<ListNode> createList(int[]... values)
	{
		List<ListNode> lists = new ArrayList<ListNode>();
		for (int i = 0; i < values.length; i++)
			lists.add(LinkedList.createLinkedList(values[i]));

		return lists;
	}

	private static void oneCase(int[]... values)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		List<ListNode> lists = createList(values);

		ListNode newHead = s1.mergeKLists(lists);
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

		oneCase(new int[]
		{ 1, 3 }, new int[]
		{ 2, 4 }, new int[]
		{ 5, 6, 7 });
	}
}
