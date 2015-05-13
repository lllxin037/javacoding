package leetcode.median.two.sorted.arrays;

public class Test {

	private static void oneCase(int[] A, int[] B) {
		System.out.println("#####################");

		Solution1 sol = new Solution1();
		System.out.println(sol.findMedianSortedArrays(A, B));

		System.out.println("#####################\n\n");

	}

	public static void main(String[] args) {
		/**/
		oneCase(new int[] { 2, 3, 7, 12, 27 }, new int[] { 1, 25, 32, 74, 89 });

		oneCase(new int[] { 25 }, new int[] { 2, 3, 7, 12, 27 });

		oneCase(new int[] { 2, 3, 7, 12, 27 }, new int[] { 25 });

		oneCase(new int[] {}, new int[] { 25 });

		oneCase(new int[] {}, new int[] {});

		oneCase(new int[] {}, new int[] { 1, 2, 3, 4, 5 });

		oneCase(new int[] {}, new int[] { 1, 2, 3, 4, 5, 6 });

		oneCase(new int[] { 1, 2 }, new int[] { 1, 2 });

	}
}
