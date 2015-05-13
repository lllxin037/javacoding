package epi.linkedlist;

import java.util.Random;

public class CopyingPostingsList
{

	public static PostingsNode copy(PostingsNode head)
	{
		if (head == null)
			return null;

		// iterates and make the list as a --> a' --> b --> b'
		PostingsNode p = head;
		while (p != null)
		{
			PostingsNode cloned = new PostingsNode(p.val, null, null);
			cloned.next = p.next;
			p.next = cloned;

			p = cloned.next;
		}

		// go through head and set jump pointers
		p = head;

		PostingsNode newHead = p.next;
		PostingsNode newCur = null;
		while (p != null)
		{
			newCur = p.next;

			PostingsNode jump = p.jump;
			if (jump != null)
				newCur.jump = jump.next;

			p = newCur.next;
		}

		// break into two lists

		p = head;
		newCur = p.next;
		while (newCur.next != null)
		{
			p.next = newCur.next;
			p = p.next;
			newCur.next = p.next;

			newCur = newCur.next;
		}

		return newHead;
	}

	private static class PostingsNode
	{
		public int val;
		public PostingsNode next;
		public PostingsNode jump;

		public PostingsNode(int x, PostingsNode next, PostingsNode jump)
		{
			val = x;
			this.next = next;
			this.jump = jump;
		}
	}

	public static <T> void checkPostingsListEqual(PostingsNode a, PostingsNode b)
	{

		while (a != null && b != null)
		{
			System.out.print("original val:	" + a.val + " ");
			if (a.jump != null)
				System.out.print("jump val " + a.jump.val);
			System.out.println("");

			System.out.print("copied val:	" + b.val + " ");
			if (b.jump != null)
				System.out.print("jump val " + b.jump.val);
			System.out.println("");

			a = a.next;
			b = b.next;
		}

		assert (a == null && b == null);
	}

	public static void main(String[] args)
	{
		Random gen = new Random();

		int n = 10;
		int seed = 100;

		PostingsNode L = null;
		PostingsNode curr = L;

		int[] array = new int[n];
		for (int i = 0; i < n; ++i)
		{
			PostingsNode temp = new PostingsNode(gen.nextInt(seed), null, null);
			array[i] = temp.val;

			if (L != null)
			{
				curr.next = temp;
				curr = temp;
			}
			else
			{
				curr = L = temp;
			}
		}

		// setup jump
		curr = L;
		for (int i = 0; i < n; i++)
		{
			// Randomly assigned a jump node.
			int jumpNum = array[gen.nextInt(n)];
			PostingsNode jump = L;
			while (jumpNum != jump.val)
				jump = jump.next;
			curr.jump = jump;

			curr = curr.next;
		}

		PostingsNode copied = copy(L);
		checkPostingsListEqual(L, copied);
	}
}
