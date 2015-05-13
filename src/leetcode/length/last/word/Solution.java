package leetcode.length.last.word;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * 
 * <pre>
 * For example,
 * Given s = "Hello World",
 * return 5.
 * </pre>
 * 
 */

public class Solution
{
	public int lengthOfLastWord(String s)
	{
		if (s == null | s.length() == 0)
			return 0;

		int last = s.length() - 1;
		while (last >= 0 && s.charAt(last) == ' ')
			last--;

		int len = 0;
		while (last >= 0 && s.charAt(last--) != ' ')
			len++;

		return len;
	}
}