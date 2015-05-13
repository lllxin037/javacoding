package leetcode.next.right.pointersII;

public class Test
{

	private static final int NULL = Integer.MIN_VALUE;

	public static TreeLinkNode build(int[] array, int i)
	{
		if (i >= array.length)
			return null; // nothing to build

		if (array[i] == NULL)
		{
			return null;
		}

		TreeLinkNode node = new TreeLinkNode(array[i]); // new node for array[i]

		node.left = build(array, 2 * i + 1); // build left sub-tree
		node.right = build(array, 2 * i + 2); // build right sub-tree

		return node;
	}

	private static void oneCase(int[] treeValues)
	{
		System.out.println("#########################");
		Solution s = new Solution();

		TreeLinkNode root = build(treeValues, 0);
		s.connect(root);
		dumpNextRightPoint(root);
		System.out.println("#########################\n\n");
	}

	private static void dumpNextRightPoint(TreeLinkNode root)
	{
		TreeLinkNode currentLeftMost = root;
		
		while (currentLeftMost != null)
		{
			TreeLinkNode p = currentLeftMost;
			while (p != null)
			{
				System.out.print(p.val + "    ");
				p = p.next;
			}
			
			System.out.println("");
			currentLeftMost = currentLeftMost.left;
		}
	}
	
	public static void main(String args[])
	{
		/*oneCase(new int[]
		{ 1, 2, 3 });
		
		oneCase(new int[]
		{ 1, 2, 3, 4, 5, NULL, 7 });
		
		oneCase(new int[]
				{ 1, 2, 3, 4, NULL, NULL, 7 });
		oneCase(new int[]
				{ 1, 2, 3, 4, NULL, NULL, 7 });*/
		
		oneCase(new int[]
				{ 2,1,3,0,7,9,1,2,NULL,1,0,NULL,NULL,8,8,NULL,NULL,NULL,NULL,7 });

		oneCase(new int[]{ 1 });
		oneCase(new int[]{ });
	}
}
