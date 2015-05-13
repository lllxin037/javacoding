package leetcode.permutations.ii;

import java.util.List;

public class Test {
	private static void oneCase(int[] num) {
		System.out.println("#########################");
		Solution1 s1 = new Solution1();

		List<List<Integer>> ret = s1.permuteUnique(num);
		for (int i = 0; i < ret.size(); i++) {
			List<Integer> items = ret.get(i);
			for (int j = 0; j < items.size(); j++) {
				System.out.print(items.get(j) + "\t");
			}
			System.out.println();
		}

		System.out.println("#########################\n\n");
	}

	public static void main(String args[]) {
		oneCase(new int[] { 1 });

		oneCase(new int[] { 1, 2 });

		oneCase(new int[] { 1, 2, 3 });

		oneCase(new int[] { 1, 1, 2 });
	}
}
