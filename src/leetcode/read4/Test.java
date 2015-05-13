package leetcode.read4;

import java.io.IOException;

public class Test {

	private static final String TEST_DATA = "1. Need a solution to read and store data from a file    coderanch.com Hii everyone..I an new to this forum, I have registered today. I want to know how to store the input values which are read from a file. The input values are all double values in a line separated by spaces. I want to read these values one after the other and store in a double typed variable. For example: The input ";

	private static void oneCase(int n) throws IOException {

		Solution1 sol = new Solution1();
		sol.setInputSource(TEST_DATA);

		char[] buf = new char[n];
		sol.read(buf, n);

		System.out.println(String.valueOf(buf));
	}

	private static void oneCase1(int n) throws IOException {

		Solution1 sol = new Solution1();
		sol.setInputSource(TEST_DATA);

		char[] buf = new char[n - 2];
		sol.read(buf, n);
		System.out.println(String.valueOf(buf));
	}

	public static void main(String[] args) throws IOException {

		oneCase(2);
		oneCase(4);
		oneCase(14);

		oneCase1(3);
		oneCase1(14);
	}
}
