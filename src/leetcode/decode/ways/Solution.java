package leetcode.decode.ways;

/**
 * <pre>
 *  A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * 
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 * </pre>
 * 
 */
public class Solution
{
	public int numDecodings(String s)
	{
		if (s == null || s.isEmpty())
			return 0;

		if (s.charAt(0) == '0')
			return 0;

		int[] dp = new int[s.length() + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 1; i < s.length(); i++)
		{
			char c = s.charAt(i);
			char p = s.charAt(i - 1);

			if (c == '0')
			{
				if (p == '1' || p == '2')
					dp[i + 1] = dp[i - 1];
				else
					return 0;
			}
			else if ((p == '2' && c <= '6') || p == '1')
			{
				dp[i + 1] = dp[i - 1] + dp[i];
			}
			else
				dp[i + 1] = dp[i];
		}

		return dp[s.length()];
	}
}