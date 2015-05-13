package leetcode.copylist.with.randompointer;

import java.util.HashMap;
import java.util.Map;

public class SolutionTest
{

	static class RandomListNode
	{
		int label;
		RandomListNode next, random;

		RandomListNode(int x)
		{
			this.label = x;
		}
	}

	private static final int NULL = Integer.MIN_VALUE;
	
	private static RandomListNode getHead(int[] data)
	{
		RandomListNode head = null;
		RandomListNode last = null;

		Map<Integer, RandomListNode> mapping = new HashMap<Integer, RandomListNode>();

		int len = data.length / 2;
		for (int i = 0; i < len; i++)
		{
			RandomListNode one = new RandomListNode(data[i]);
			mapping.put(data[i], one);
			if (head == null)
			{
				head = last = one;
			}
			else
			{
				last.next = one;
				last = last.next;
			}

		}

		// setup random
		for (int i = 0; i < len; i++)
		{
			RandomListNode one = mapping.get(data[i]);

			RandomListNode random = mapping.get(data[len + i]);
			if (random != null)
				one.random = random;
		}

		return head;
	}

	private static void dump(RandomListNode head)
	{
		System.out.print("dump list: ");
		
		RandomListNode current = head;
		while (current != null)
		{
			System.out.print(current.label + "  " );
			current = current.next;
		}
		
		current = head;
		while (current != null)
		{
			if (current.random == null)
				System.out.print("  null  " );
			else
				System.out.print(current.random.label + "  " );
			current = current.next;
		}
		System.out.print("\n");
	}
	
	public static void main(String[] args)
	{
		Solution s = new Solution();

		int[] s1 =
		{ 1, 2, 2, 2 };
		RandomListNode head = getHead(s1);
		dump( s.copyRandomList(head) );

		int[] s2 =
		{ -1, NULL };
		head = getHead(s2);
		dump( s.copyRandomList(head) );
		
	 	int[] s3={-1,8,7,-3,4,4,-3,NULL,NULL,-1};
	 	head = getHead(s3);
		dump( s.copyRandomList(head) );
	}
}
