package leetcode.next.right.pointers;

/**
 * Given a binary tree
 * 
 * <pre>
 *     struct TreeLinkNode {
 *       TreeLinkNode *left;
 *       TreeLinkNode *right;
 *       TreeLinkNode *next;
 *     }
 * </pre>
 * 
 * Populate each next pointer to point to its next right node. If there is no
 * next right node, the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 * 
 * Note:
 * 
 * You may only use constant extra space. 
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two
 * children).
 * 
 * 
 * <pre>
 * For example,
 * Given the following perfect binary tree,
 * 
 *          1
 *        /  \
 *       2    3
 *      / \  / \
 *     4  5  6  7
 * 
 * After calling your function, the tree should look like:
 * 
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \  / \
 *     4->5->6->7 -> NULL
 * </pre>
 * 
 */
public class Solution
{
	public void connect(TreeLinkNode root)
	{
		TreeLinkNode nextLeftMost = null;
		
		TreeLinkNode currentLeftMost = root;
		TreeLinkNode current = currentLeftMost;
		
		while (currentLeftMost != null || nextLeftMost != null)
		{	
			// 	go to next level;
			nextLeftMost = currentLeftMost.left;			
			TreeLinkNode nextCurrent = nextLeftMost;
			
			current = currentLeftMost;
			// one new level to handle.
			while (current != null && nextCurrent != null)
			{
				// right node
				if (current.left != nextCurrent && current.right != nextCurrent)
				{
					nextCurrent.next = current.left;
					nextCurrent = nextCurrent.next;
					continue;
				}
				
				// left node.
				nextCurrent.next = current.right;				
				nextCurrent = nextCurrent.next;
				
				current = current.next;
			}
		
			currentLeftMost = nextLeftMost;
		}
	}
}
