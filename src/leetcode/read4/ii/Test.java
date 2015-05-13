package leetcode.read4.ii;

import java.io.IOException;

public class Test {
	private static void oneCase(String s, int[] readCount) throws IOException {
		Solution1 sol = new Solution1();
		sol.setInputSource(s);

		System.out.println("***************************");

		for (int i = 0; i < readCount.length; i++) {
			char[] buf = new char[readCount[i]];

			int read = sol.read(buf, readCount[i]);
			String s1 = new String(buf, 0, read);
			System.out.print(s1 + "\n");
		}

		System.out.println("***************************");
	}

	public static void main(String[] args) throws Exception {
		oneCase("ab", new int[] { 1, 2 });

		oneCase("abcdestf", new int[] { 5, 2 });
		oneCase("abcdefghijklmnopqrstuvwxyz", new int[] { 15, 5, 8, 4 });
	}
}
