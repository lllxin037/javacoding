package leetcode.reverse.words.stringii;

/**
 * Question: Given an input string, reverse the string word by word. A word is
 * defined as a sequence of non-space characters. The input string does not
 * contain leading or trailing spaces and the words are always separated by a
 * single space.
 * 
 * <pre>
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * </pre>
 * 
 * Could you do it in-place without allocating extra space?
 * 
 */

public class Solution {

	public void reverseWords(char[] s) {

		if (s == null || s.length <= 1)
			return;

		reverse(s, 0, s.length - 1);

		int last = 0;
		int cur = 0;
		while (cur <= s.length) {

			while (cur < s.length && s[cur] != ' ')
				cur++;

			if (cur == s.length || s[cur] == ' ') {
				reverse(s, last, cur - 1);
				cur++;
				last = cur;
			}
		}
	}

	private void reverse(char[] s, int start, int end) {
		while (start < end) {
			char c = s[start];
			s[start] = s[end];
			s[end] = c;
			start++;
			end--;
		}
	}
}
