package leetcode.largest.number;

public class Test {

	private static void onecase(int[] vals) {
		Solution s = new Solution();
		System.out.println(s.largestNumber(vals));
	}

	public static void main(String[] args) {

		onecase(new int[] { 0, 0 });
		onecase(new int[] { 1,2,3,4,5,6,7,8,9,0 });
		onecase(new int[] { 3, 30, 34, 5, 9 });
	}
}
