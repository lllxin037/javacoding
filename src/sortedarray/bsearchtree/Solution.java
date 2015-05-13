package sortedarray.bsearchtree;


/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 */

public class Solution
{
    public TreeNode sortedArrayToBST(int[] num) 
	{
		if (num == null || num.length == 0)
			return null;
	
		return sortListToBST(num, 0, num.length-1);
	}
	
	private TreeNode sortListToBST(int[] num, int start, int end)
	{
		if (start > end)
			return null;
		
		int middle = start + (end - start)/2;
		int v = num[middle];
			
		TreeNode t = new TreeNode(v);		
		
		t.left = sortListToBST(num, start, middle -1);
		t.right = sortListToBST(num, middle + 1, end);
		
		return t;
	}
}
