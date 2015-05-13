package leetcode.interleaving.string;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 * <pre>
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * 
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 * </pre>
 * 
 */
public class RecursiveSolution
{
	public boolean isInterleave(String s1, String s2, String s3)
	{
		if (s3 == null)
			return (s1 == null && s2 == null);

		if (s3.isEmpty())
			return ((s1 == null || s1.isEmpty()) && (s2 == null || s2.isEmpty()));

		if (s1 != null && !s1.isEmpty() && (s1.charAt(0) == s3.charAt(0)))
		{
			boolean ret = isInterleave(s1.substring(1), s2, s3.substring(1));
			if (ret)
				return true;
		}

		if (s2 != null && !s2.isEmpty() && (s2.charAt(0) == s3.charAt(0)))
		{
			boolean ret = isInterleave(s1, s2.substring(1), s3.substring(1));
			if (ret)
				return true;
		}

		return false;
	}
}
