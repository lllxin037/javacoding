package leetcode.linkedlist;

public class LinkedList
{
	public static void print(ListNode head)
	{
		ListNode p = head;
		while (p != null)
		{
			System.out.print(p.val + "   ");
			p = p.next;
		}
		System.out.println();
	}
	
	public static ListNode createLinkedList(int[] values)
	{
		if (values == null || values.length == 0)
			return null;
		
		ListNode head = null;
		ListNode current = null;
		for (int i = 0; i < values.length; i++)
		{
			ListNode p = new ListNode(values[i]);
			if (head == null)
			{
				head = current = p;
				continue;
			}
			
			current.next = p;
			current = p;
			
		}
		
		return head;
	}
}
