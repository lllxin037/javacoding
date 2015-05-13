package leetcode.Intersection.LinkedLists;

import leetcode.linkedlist.ListNode;

public class Solution
{
	public ListNode getIntersectionNode(ListNode headA, ListNode headB)
	{

		int n = 0;
		int m = 0;

		ListNode tmp = headA;
		while (tmp != null)
		{
			n++;
			tmp = tmp.next;
		}

		tmp = headB;
		while (tmp != null)
		{
			m++;
			tmp = tmp.next;
		}

		for (int i = 0; i < n - m; i++)
			headA = headA.next;
		for (int i = 0; i < m - n; i++)
			headB = headB.next;

		if (headA == null || headB == null)
			return null;

		while (headA != null)
		{
			if (headA.val == headB.val)
				return headA;

			headA = headA.next;
			headB = headB.next;
		}

		return null;
	}
}
