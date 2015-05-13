package construct.btree.preAndInorder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given inorder and preorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 * 
 */

public class Solution
{
	public TreeNode buildTree(int[] preorder, int[] inorder)
	{
		if (inorder == null || preorder == null || inorder.length == 0
				|| preorder.length == 0)
			return null;

		Map<Integer, Integer> mapping = createInOrderMapping(inorder);

		return createTree(preorder, mapping, inorder.length, 0);
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

	private TreeNode createTree(int[] preorder, Map<Integer, Integer> mapping,
			int len, int offset)
	{
		if (len <= 0)
			return null;

		int rootV = preorder[0];
		int leftLen = mapping.get(rootV) - offset;
		int rightLen = len - leftLen - 1;

		TreeNode root = new TreeNode(rootV);
		
		int[] leftTree = Arrays.copyOfRange(preorder, 1, leftLen + 1);
		root.left = createTree(leftTree, mapping, leftLen, offset);

		int[] rightTree = Arrays.copyOfRange(preorder, leftLen + 1, len);
		root.right = createTree(rightTree, mapping, rightLen,
				mapping.get(rootV) + 1);
		return root;
	}
}