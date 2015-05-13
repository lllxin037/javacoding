package leetcode.reverse.words.stringii;

public class Test {

	private static void oneCase(String s) {
		System.out.println("#####################");
		Solution sol = new Solution();
		char[] arr = s.toCharArray();
		sol.reverseWords(arr);
		System.out.println(arr);

		System.out.println("#####################\n\n");

	}

	public static void main(String[] args) {
		/**/
		oneCase("");
		oneCase("a");
		oneCase("the");
		oneCase("the blue");
		oneCase("the sky is blue");
	}
}
