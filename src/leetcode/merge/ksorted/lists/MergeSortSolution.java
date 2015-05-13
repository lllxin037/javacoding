package leetcode.merge.ksorted.lists;

import java.util.List;

import leetcode.linkedlist.ListNode;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 */

public class MergeSortSolution
{
	public ListNode mergeKLists(List<ListNode> lists)
	{
		if (lists == null || lists.size() == 0)
			return null;

		int last = lists.size() - 1;

		while (last > 0)
		{
			int cur = 0;
			while (cur < last)
			{
				ListNode one = lists.get(cur);
				ListNode two = lists.get(last);

				lists.set(cur, mergeTwo(one, two));

				cur++;
				last--;
			}
		}
		return lists.get(0);
	}

	private ListNode mergeTwo(ListNode one, ListNode two)
	{
		ListNode head = new ListNode(0);
		ListNode cur = head;

		// merge
		while (one != null || two != null)
		{
			if (two == null || ( one != null && one.val < two.val) )
			{
				cur.next = one;
				one = one.next;
			}
			else
			{
				cur.next = two;
				two = two.next;
			}

			cur = cur.next;
		}

		return head.next;

	}
}