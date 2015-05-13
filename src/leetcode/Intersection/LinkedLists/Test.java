package leetcode.Intersection.LinkedLists;

import leetcode.linkedlist.LinkedList;
import leetcode.linkedlist.ListNode;

public class Test
{
	private static void oneCase(int[] list1, int[] list2)
	{
		ListNode a = LinkedList.createLinkedList(list1);
		ListNode b = LinkedList.createLinkedList(list2);

		Solution s = new Solution();
		LinkedList.print(s.getIntersectionNode(a, b));

	}

	public static void main(String[] args)
	{
		// A = {1,3,5,7,9,11} and B = {2,4,9,11},
		oneCase(new int[]
		{ 1, 3, 5, 7, 9, 11 }, new int[]
		{ 2, 4, 9, 11 });
	}
}
