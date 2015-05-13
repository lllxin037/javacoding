package leetcode.min.rotated.sorted.array;

public class Test
{
	public static void main(String[] args)
	{
/*		Solution solution = new Solution();
		System.out.println(solution.findMin(new int[]
		{ 0, 1, 2, 4, 5, 6, 7 }));

		System.out.println(solution.findMin(new int[]
		{ 2, 4, 5, 6, 7, 0, 1 }));

		System.out.println(solution.findMin(new int[]
		{ 5, 6, 7, 0, 1, 2, 4 }));

		System.out.println(solution.findMin(new int[]
		{ 6, 7, 0, 1, 2, 4, 5 })); */
		
		SolutionWithDuplicate solution = new SolutionWithDuplicate();
		System.out.println(solution.findMin(new int[]{3,3,1,3}));
		
		System.out.println(solution.findMin(new int[]{10, 1,10,10,10}));
	}
}
