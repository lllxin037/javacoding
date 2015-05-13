package leetcode.merge.ksorted.lists;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import leetcode.linkedlist.ListNode;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 */

public class Solution
{
	public ListNode mergeKLists(List<ListNode> lists)
	{
		if (lists == null || lists.size() == 0)
			return null;

		int size = lists.size();

		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(size,
				new Comparator<ListNode>()
				{
					public int compare(ListNode o1, ListNode o2)
					{
						if (o1.val < o2.val)
							return -1;
						if (o1.val > o2.val)
							return 1;
						return 0;
					}
				});

		for (ListNode one : lists)
			if (one != null)
				heap.offer(one);

		ListNode head = new ListNode(0);
		ListNode cur = head;

		while (!heap.isEmpty())
		{
			ListNode node = heap.poll();
			cur.next = node;
			cur = cur.next;
			
			if (node.next != null)
				heap.offer(node.next);
		}

		return head.next;
	}
}