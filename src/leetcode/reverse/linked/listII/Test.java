package leetcode.reverse.linked.listII;

import leetcode.linkedlist.LinkedList;
import leetcode.linkedlist.ListNode;

public class Test
{
	private static void oneCase(int[] values, int m, int n)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		ListNode ret = s1.reverseBetween(LinkedList.createLinkedList(values),
				m, n);
		LinkedList.print(ret);

		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase(new int[]{}, 0, 0);
		oneCase(new int[]{1,2,3,4,5}, 2, 4);
		oneCase(new int[]{1}, 1, 1);
		oneCase(new int[]{1,2}, 1, 2);
		
		oneCase(new int[]{1,2,3}, 1, 3);
		oneCase(new int[]{1,2,3}, 1, 2);
	}
}
