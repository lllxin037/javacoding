package leetcode.rotate.list;

import leetcode.linkedlist.LinkedList;

public class Test
{
	private static void oneCase(int[] values, int n)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		LinkedList
				.print((s1.rotateRight(LinkedList.createLinkedList(values), n)));
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		/**/
		oneCase(new int[]
		{ 1 }, 0);

		oneCase(new int[]
		{ 1 }, 2);

		oneCase(new int[]
		{ 1, 2 }, 1);

		oneCase(new int[]
		{ 1, 2 }, 2);

		oneCase(new int[]
		{ 1, 2 }, 3);

		oneCase(new int[]
		{ 1, 2, 3, 4, 5 }, 2);
	}
}
