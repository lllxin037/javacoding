package leetcode.insertionsortlist;



/**
 * <pre>
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 * </pre>
 * 
 *  O(n log n) 
 */

/**
 * Uses merge sort algorithm to sort on linked list.
 * 
 */

public class SolutionTest
{	

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
	
	static void dumpLinkedList(ListNode head)
	{
		ListNode p = head;
		
		System.out.print("the list: ");
		while (p!=null)
		{
			System.out.print(p.val + "    ");
			p = p.next;
		}
		System.out.print("\n");		
	}
	
	static ListNode arrayToList(int[] arrays)
	{
		if (arrays == null)
			return null;
		
		ListNode head = null, current = null;
		
		for (int i = 0; i < arrays.length; i++)
		{
			if (head == null)
				head = current = new ListNode(arrays[i]);
			else
			{
				current.next = new ListNode(arrays[i]);
				current = current.next;
			}
		}
		return head;
	}
	
	public static void main(String args[])
	{
		Solution s1 = new Solution();
		int[] arrays = {};
		
		dumpLinkedList( s1.insertionSortList(arrayToList(arrays)) );
		
		int[] array1 = {9,8,7,6,5,4,3,2,1,0,100,20,11};
		
		dumpLinkedList( s1.insertionSortList(arrayToList(array1)) );
		
		int[] array2 = {0, 9,3,150,6,7,4,2,1, 8};
		
		dumpLinkedList( s1.insertionSortList(arrayToList(array2)) );
	}
}