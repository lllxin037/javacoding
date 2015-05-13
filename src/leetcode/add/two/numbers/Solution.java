package leetcode.add.two.numbers;

import leetcode.linkedlist.ListNode;

/**
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * <pre>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * </pre>
 * 
 */

public class Solution
{
	public ListNode addTwoNumbers(ListNode l1, ListNode l2)
	{
		if (l1 == null && l2 == null)
			return null;

		int carry = 0;
		ListNode newHead = new ListNode(0);
		ListNode cur = newHead;

		while (l1 != null || l2 != null)
		{
			int nextVal = 0;
			if (l1 == null || l2 == null)
			{
				if (l1 == null)
				{
					nextVal = l2.val;
					l2 = l2.next;
				}
				else
				{
					nextVal = l1.val;
					l1 = l1.next;
				}
			}
			else
			{
				nextVal = l1.val + l2.val;
				l1 = l1.next;
				l2 = l2.next;
			}

			boolean withCarry = (nextVal + carry >= 10);
			nextVal = withCarry ? (nextVal + carry - 10) : nextVal + carry;
			carry = withCarry ? 1 : 0;

			ListNode tmp = new ListNode(nextVal);
			cur.next = tmp;
			
			cur = cur.next;
		}

		if (carry != 0)
		{
			ListNode tmp = new ListNode(carry);
			cur.next = tmp;
		}
		return newHead.next;
	}
}
