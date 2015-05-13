package leetcode.longest.substring.two.distinct.characters;

/**
 * http://www.danielbit.com/blog/puzzle/leetcode/leetcode-longest-substring-with
 * -at-most-two-distinct-characters
 * 
 * https://changhaz.wordpress.com/2014/11/26/leetcode-longest-substring-with-at-
 * most-two-distinct-characters/
 */
public class Solution1
{
	public int lengthOfLongestSubstringTwoDistinct(String s)
	{
		// a1 & a2 are to records the latest positions on two characters.

		int a1 = 0, a2 = -1, maxLen = 0;
		int left = 0;

		int k = 1;
		for (; k < s.length(); k++)
		{
			char c = s.charAt(k);

			if (c == s.charAt(a1))
				a1 = k;
			else if (a2 == -1 || c == s.charAt(a2))
				a2 = k;
			else
			{
				// move the left edge of the window

				maxLen = Math.max(maxLen, k - left);

				left = Math.min(a1 + 1, a2 + 1);
				a1 = Math.max(a1, a2);
				a2 = k;
			}
		}

		return Math.max(maxLen, k - left);
	}
}
