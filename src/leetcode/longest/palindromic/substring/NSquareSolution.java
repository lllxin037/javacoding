package leetcode.longest.palindromic.substring;

/**
 * Given a string S, find the longest palindromic substring in S. You may assume
 * that the maximum length of S is 1000, and there exists one unique longest
 * palindromic substring.
 * 
 */

public class NSquareSolution
{
	public String longestPalindrome(String s)
	{
		if (s == null || s.length() <= 1)
			return s;

		String palindrome = "";

		String t = isParlindrome(s, 0, 1);
		if (t.length() > palindrome.length())
		{
			palindrome = t;
			if (t.length() == s.length())
				return s;
		}

		for (int i = 1; i < s.length() - 1; i++)
		{
			t = isParlindrome(s, i - 1, i + 1);
			if (t.length() > palindrome.length())
			{
				palindrome = t;
				if (t.length() == s.length())
					break;
			}

			t = isParlindrome(s, i, i + 1);
			if (t.length() > palindrome.length())
			{
				palindrome = t;
				if (t.length() == s.length())
					break;
			}
		}

		return palindrome;
	}

	private String isParlindrome(String s, int left, int right)
	{
		while (left >= 0 && right < s.length()
				&& s.charAt(left) == s.charAt(right))
		{
			left--;
			right++;
		}

		return s.substring(left + 1, right);
	}
}