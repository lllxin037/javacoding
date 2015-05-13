package leetcode.add.two.numbers;

import leetcode.linkedlist.LinkedList;

public class Test
{

	private static void oneCase(int[] l1, int[] l2)
	{
		System.out.println("#####################");
		Solution sol = new Solution();
		LinkedList.print(sol.addTwoNumbers(LinkedList.createLinkedList(l1),
				LinkedList.createLinkedList(l2)));

		System.out.println("#####################\n\n");

	}

	public static void main(String[] args)
	{
		/**/
		oneCase(new int[]
		{ 0 }, new int[]
		{ 0 });
		oneCase(new int[]
		{ 9, 8 }, new int[]
		{ 1 });
		oneCase(new int[]
		{ 2, 4, 3 }, new int[]
		{ 5, 6, 4 });
	}
}
