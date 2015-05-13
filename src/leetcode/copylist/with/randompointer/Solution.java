package leetcode.copylist.with.randompointer;

import leetcode.copylist.with.randompointer.SolutionTest.RandomListNode;

/**
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 */
public class Solution
{
	public RandomListNode copyRandomList(RandomListNode head)
	{
		RandomListNode clonedHead = null;

		//RandomListNode last = null;
		RandomListNode current = head;
		
		//clone the list and set the random to the original node. insert any newly created node
		//after the original node.
		
		while (current != null)
		{
			RandomListNode newOne = new RandomListNode(current.label);
			if (clonedHead == null)
			{
				clonedHead = newOne;		
			}

			RandomListNode tmp = current.next;
			current.next = newOne;
			newOne.next = tmp;
			
			current = tmp;
		}
		
		// establish the random pointer in cloned nodes. It is "original->random->next" if applies
		RandomListNode original = head;
		RandomListNode cloned = null;
		
		while (original != null)
		{
			cloned =  original.next;
			if (cloned == null)
			{
				//error.
			}
		
			if (original.random != null)
				cloned.random = original.random.next;			
			
			original = cloned.next;			
		}
		
		// restore the original list and create the new list
		original = head;
		cloned = null;
		while (original != null)
		{
			cloned =  original.next;
			if (cloned == null)
			{
				//error.
			}
		
			original.next = cloned.next; 	
			original = cloned.next;			
			
			if (original != null)
				cloned.next = original.next;
		}
		
		return clonedHead;
	}
} 