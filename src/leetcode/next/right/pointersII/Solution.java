package leetcode.next.right.pointersII;

/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * 
 * What if the given tree could be any binary tree? Would your previous solution
 * still work?
 * 
 * Note:
 * 
 * You may only use constant extra space.
 * 
 * <pre>
 * For example,
 * Given the following binary tree,
 * 
 *          1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 * 
 * After calling your function, the tree should look like:
 * 
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \    \
 *     4-> 5 -> 7 -> NULL
 * </pre>
 * 
 */
public class Solution
{
	public void connect(TreeLinkNode root)
	{
		TreeLinkNode nextLeftMost = null;
		TreeLinkNode currentLeftMost = root;		

		while (currentLeftMost != null || nextLeftMost != null)
		{
			// go to next level;
			
			//search for the 1st left most.			
	
			TreeLinkNode current = currentLeftMost;			
			nextLeftMost = findNextLevelNode(currentLeftMost);

			TreeLinkNode nextCurrent = nextLeftMost;
			current = currentLeftMost;
			
			// one new level to handle.
			while (current != null && nextCurrent != null)
			{
				TreeLinkNode nextCurrent1 = null;
				while ( current != null)
				{
					if (current.left != null && current.left != nextCurrent)
					{
						nextCurrent1 = current.left;
						break;
					}
					if (current.right != null && current.right != nextCurrent)
					{
						nextCurrent1 = current.right;
						break;
					}
					
					current = current.next;
				}

				if ( current == null)
					break;
				
				nextCurrent.next = nextCurrent1;				
				nextCurrent = nextCurrent.next;
				
				// only go to next node if the right node is used
				if (nextCurrent1 == current.right)
					current = current.next;
			}

			currentLeftMost = nextLeftMost;
		}
	}
	
	private TreeLinkNode findNextLevelNode(TreeLinkNode current)
	{
		TreeLinkNode p = current;
		while ( p != null)
		{
			if (p.left != null )
				return p.left;
			if (p.right != null)
				return p.right;
			
			p = p.next;
		}
		
		return null;
	}
}
