import leetcode.linkedlist.LinkedList;
import leetcode.linkedlist.ListNode;

public class SimpleTest
{
	public static ListNode reverseIterative(ListNode head)
	{
		ListNode prev = null, next = null;
		while (true)
		{
			if (head == null)
				return null;
			next = head.next;
			head.next = prev;
			prev = head;
			if (next == null)
				return head;
			head = next;

		}
	}

	public static ListNode reverseRecursive(ListNode head)
	{
		ListNode reverseHead;
		if (head == null)
			return null;
		if (head.next == null)
			return head;
		ListNode secondElement = head.next;
		head.next = null;
		reverseHead = reverseRecursive(secondElement);
		secondElement.next = head;
		return reverseHead;
		

	}

	public static char[] reverseCharacters(char[] s2, int start, int end)
	{

		if (s2 == null)
			return s2;
		if (s2.length == 0)
			return s2;
		if (end < start)
			return s2;

		while (start < end)
		{
			char temp = s2[start];
			s2[start++] = s2[end];
			s2[end--] = temp;
		}
		return s2;
	}

	public static void main(String[] args)
	{
/*
		ListNode p = LinkedList.createLinkedList(new int[]
		{ 3, 6, 5 });
		LinkedList.print(reverseIterative(p));
		p = LinkedList.createLinkedList(new int[]
		{ 3 });
		LinkedList.print(reverseIterative(p));
		p = LinkedList.createLinkedList(new int[]
		{ 3, 2 });

		LinkedList.print(reverseIterative(p));
*/
		
		ListNode p = LinkedList.createLinkedList(new int[] { 3, 6, 5 });
		  LinkedList.print(reverseRecursive(p)); p =
		  LinkedList.createLinkedList(new int[] { 3 });
		  LinkedList.print(reverseRecursive(p)); p =
		  LinkedList.createLinkedList(new int[] { 3, 2 });
		  
		  LinkedList.print(reverseRecursive(p));
		 
		
		/*
		String str = "Alice in Wonderland";
		char[] S2 = str.toCharArray();

		System.out.println("Char Array before --> " + new String(S2));
		S2 = reverseCharacters(S2, 0, S2.length - 1);
		System.out.println("Char Array after --> " + new String(S2));*/
	}
}
