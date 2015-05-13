package leetcode.reverse.linked.listII;

import leetcode.linkedlist.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 
 * return 1->4->3->2->5->NULL.
 * 
 * Note: Given m, n satisfy the following condition: 1 <= m <= n <= length of list.
 * 
 */

public class Solution
{
	public ListNode reverseBetween(ListNode head, int m, int n)
	{
		ListNode ret = head;
		
		ListNode p = head;
		ListNode pre = null;

		for (int i = 1; i < m; i++)
		{	
			pre = p;
			p = p.next;
		}
		
		for (int i = 0; i < n - m ; i++)
		{
			ListNode toShift = p.next;
			
			p.next = toShift.next;
			
			if (pre != null)
			{
				toShift.next = pre.next;
				pre.next = toShift;
			}
			else
			{
				toShift.next = ret;
				ret = toShift;
			}
		}
		
		return ret;		
	}
}