package leetcode.partition.list;

import leetcode.linkedlist.LinkedList;
import leetcode.linkedlist.ListNode;

public class Test
{
	private static void oneCase(int[] values, int x)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		ListNode ret = s1.partition(LinkedList.createLinkedList(values), x);
		LinkedList.print(ret);

		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase(new int[]{}, 3);
		oneCase(new int[]{3}, 3);		
		oneCase(new int[]{3, 1}, 2);
		
		oneCase(new int[]{3, 1, 2}, 3);

		
		oneCase(new int[]{3, 2, 5, 2}, 3);
		
		oneCase(new int[]{1, 4, 3, 2, 5, 2}, 3);
	}
}
