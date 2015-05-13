package leetcode.reverse.nodes.kgroup;

import leetcode.linkedlist.ListNode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * 
 * If the number of nodes is not a multiple of k then left-out nodes in the end
 * should remain as it is.
 * 
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * 
 * Only constant memory is allowed.
 * 
 * <pre>
 * For example,
 * Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * </pre>
 * 
 */

public class Solution
{
	public ListNode reverseKGroup(ListNode head, int k)
	{
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode p = head;
		
 		ListNode[] newHeadTail = new ListNode[2];

		ListNode tail = dummyHead;
		while (p != null)
		{
			newHeadTail[0] = null;
			newHeadTail[1] = null;
			
			int done = reverse(p, k, newHeadTail);

			if (done < k)
			{
				// reverse back.
				reverse(newHeadTail[0], k, newHeadTail);
				break;
			}

			tail.next = newHeadTail[0];
			tail = newHeadTail[1];
			p = tail.next;
		}

		return dummyHead.next;
	}

	private int reverse(ListNode head, int k, ListNode[] newHeadTail)
	{
		if (head == null)
			return 0;

		if (head.next == null)
		{
			newHeadTail[0] = head;
			newHeadTail[1] = head;
	
			return 1;
		}

		ListNode p = head;
		ListNode pre = null;

		int count = k;
		while (count > 0 && p != null)
		{
			ListNode q = p.next;
			p.next = pre;
			pre = p;
			
			//track the new tail.
			if (pre.next == null)
				newHeadTail[1] = pre;

			p = q;
			count--;
		}

		newHeadTail[0] = pre;
		newHeadTail[1].next = p;

		return k - count;
	}
}
