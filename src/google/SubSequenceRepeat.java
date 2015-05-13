package google;

/**
 * Given a string (1-d array) , find if there is any sub-sequence that repeats
 * itself. Here, sub-sequence can be a non-contiguous pattern, with the same
 * relative order.
 * 
 * <pre>
 * Eg: 
 * 
 * 1. abab <------yes, ab is repeated 
 * 2. abba <---- No, a and b follow different order 
 * 3. acbdaghfb <-------- yes there is a followed by b at two places 
 * 4. abcdacb <----- yes a followed by b twice 
 * 
 * The above should be applicable to ANY TWO (or every two) characters in the string and optimum over time. 
 * 
 * In the sense, it should be checked for every pair of characters in the string.
 * </pre>
 * 
 */

public class SubSequenceRepeat
{

	public int check(String s)
	{
		if (s == null || s.length() < 4)
			return 0;

		int len = s.length();
		int[][] dp = new int[len + 1][len + 1];
		dp[0][0] = 0;

		for (int i = 1; i < len; i++)
			dp[i][0] = 0;
		for (int i = 1; i < len; i++)
			dp[0][i] = 0;

		for (int i = 0; i < len; i++)
		{
			for (int j = 0; j < len; j++)
			{
				if (s.charAt(i) == s.charAt(j) && i != j)
				{
					dp[i + 1][j + 1] = Math.max(dp[i][j] + 1, dp[i][j + 1]);
					dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i + 1][j]);
				}
				else
					dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
			}
		}

		return dp[len][len];
	}

	public static void main(String args[])
	{
		SubSequenceRepeat s = new SubSequenceRepeat();
		String[] strs = new String[]
		{ "abab", "abba", "acbdaghfb", "abcdacb" };

		for (String t : strs)
			System.out.println(s.check(t));
	}
}
