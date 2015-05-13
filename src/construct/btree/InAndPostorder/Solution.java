package construct.btree.InAndPostorder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 * 
 */

public class Solution
{
	public TreeNode buildTree(int[] inorder, int[] postorder)
	{
		if (inorder == null || postorder == null || inorder.length == 0
				|| postorder.length == 0)
			return null;

		Map<Integer, Integer> mapping = createInOrderMapping(inorder);

		return createTree(postorder, mapping, inorder.length, 0);
	}

	private Map<Integer, Integer> createInOrderMapping(int[] inorder)
	{
		Map<Integer, Integer> ret = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++)
		{
			ret.put(Integer.valueOf(inorder[i]), Integer.valueOf(i));
		}
		return ret;
	}

	private TreeNode createTree(int[] postorder, Map<Integer, Integer> mapping,
			int len, int offset)
	{
		if (len <= 0)
			return null;

		int rootV = postorder[len - 1];
		int leftLen = mapping.get(rootV) - offset;
		int rightLen = len - leftLen - 1;

		TreeNode root = new TreeNode(rootV);

		int[] leftTree = Arrays.copyOfRange(postorder, 0, leftLen);
		root.left = createTree(leftTree, mapping, leftLen, offset);
		
		int[] rightTree = Arrays.copyOfRange(postorder, leftLen, len - 1);
		root.right = createTree(rightTree, mapping, rightLen, mapping.get(rootV) + 1);
		return root;
	}
}