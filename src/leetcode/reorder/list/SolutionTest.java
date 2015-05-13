package leetcode.reorder.list;

/**
 * Given a singly linked list L: L0->L1->... ->Ln-1->Ln, reorder it to:
 * L0->Ln->L1->Ln-1->L2->Ln-2->...
 * 
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 */
public class SolutionTest
{
	// Definition for singly-linked list.
	static class ListNode
	{
		int val;
		ListNode next;

		ListNode(int x)
		{
			val = x;
			next = null;
		}
	}
	
	private static ListNode createList(int[] values)
	{
		ListNode head = null;
		ListNode current = null;
		
		for (int i = 0; i < values.length; i++)
		{
			ListNode one = new ListNode(values[i]);
			if (head == null)
			{
				head = one;
				current = one;
				continue;
			}
			
			current.next = one;
			current = current.next;
		}
		
		return head;
	}
	
	private static void dumpList(ListNode head)
	{
		ListNode p = head;
		
		System.out.print("list: ");
		while (p != null)
		{
			System.out.print( p.val + "  ");
			p = p.next;
		}
		
		System.out.print("\n");
	}
	
	public static void main(String[] args)
	{
		Solution sol = new Solution();
		
		int[] arr1 = {1,2,3,4};		
		ListNode head = createList(arr1);
		sol.reorderList( head ); 
		dumpList(head);
		
		int[] arr2 = {1,2,3,4,5};	
		head = createList(arr2);
		sol.reorderList( head ); 
		dumpList(head);
		
		int[] arr3 = {1};
		head = createList(arr3);
		sol.reorderList( null ); 
		dumpList(head);
		
		int[] arr4 = {1,2};
		head = createList(arr4);
		sol.reorderList( null ); 
		dumpList(head);		

		int[] arr5 = {1,2,3};
		head = createList(arr5);
		sol.reorderList( head ); 
		dumpList(head);	
	}
}
