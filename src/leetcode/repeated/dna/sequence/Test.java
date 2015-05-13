package leetcode.repeated.dna.sequence;

public class Test {

	private static void oneCase(String s) {
		Solution s1 = new Solution();
		System.out.println(s1.findRepeatedDnaSequences(s));

	}

	public static void main(String[] args) {

		oneCase("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
	}
}
