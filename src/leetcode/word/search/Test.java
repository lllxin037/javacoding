package leetcode.word.search;

public class Test
{
	private static void oneCase(String[] values, String s)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		char[][] board = new char[values.length][];
		for (int i = 0; i < values.length; i++)
		{
			board[i] = values[i].toCharArray();
		}
		System.out.println(s1.exist(board, s));
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase(new String[]
		{ "aaaa", "aaaa", "aaaa" }, "aaaaaaaaaaaaa");

		oneCase(new String[]
		{ "a" }, "a");

		oneCase(new String[]
		{ "ABCE", "SFCS", "ADEE" }, "ABCCED");
		oneCase(new String[]
		{ "ABCE", "SFCS", "ADEE" }, "SEE");
		oneCase(new String[]
		{ "ABCE", "SFCS", "ADEE" }, "ABCB");

		oneCase(new String[]
		{ "aaa", "abb", "abb", "bbb", "bbb", "aaa", "bbb", "abb", "aab", "aba" },
				"aabaaaabbb");

	}
}
