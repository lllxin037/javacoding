package leetcode.reverse.words.string;

/**
 * Given an input string, reverse the string word by word.
 * 
 * <pre>
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * </pre>
 * 
 * click to show clarification.
 * 
 */

public class TwoReverseSolution
{
	public String reverseWords(String s)
	{
		if (s == null || s.length() == 0)
			return s;

		// reverse the whole string then reverse words one by one.
		StringBuilder sb = initialize(s.toCharArray());
		if (sb.length() <= 1)
			return sb.toString();

		char[] sba = sb.toString().toCharArray();
		reverse(sba, 0, sba.length - 1);

		int cur = 0;
		int last = 0;

		while (cur < sba.length)
		{
			while (cur < sba.length && sba[cur] != ' ')
				cur++;

			if (cur - last > 0)
			{
				reverse(sba, last, cur - 1);
				last = cur + 1;
				cur++;
			}
		}

		return new String(sba);
	}

	private StringBuilder initialize(char[] s)
	{
		// trim the heading, tailor, also the extra space.
		StringBuilder sb = new StringBuilder();
		int cur = 0;
		while (cur < s.length && s[cur] == ' ')
			cur++;

		int tail = s.length - 1;
		while (tail >= 0 && s[tail] == ' ')
			tail--;

		while (cur <= tail)
		{
			if (s[cur] != ' ')
				sb.append(s[cur]);
			else if (cur + 1 <= tail && s[cur + 1] != ' ')
				sb.append(' ');

			cur++;
		}

		return sb;
	}

	private void reverse(char[] s, int left, int right)
	{
		while (left < right)
		{
			char c = s[left];
			s[left] = s[right];
			s[right] = c;
			left++;
			right--;
		}
	}
}