package leetcode.one.edit.instance;

/**
 * Given two strings S and T, determine if they are both one edit distance
 * apart.
 * 
 * <pre>
 * Hint:
 * 1. If | n ¨C m | is greater than 1, we know immediately both are not one-edit distance apart.
 * 2. It might help if you consider these cases separately, m == n and m ¡Ù n.
 * 3. Assume that m is always ¡Ü n, which greatly simplifies the conditional statements. If m > n, we could just simply swap S and T.
 * 4. If m == n, it becomes finding if there is exactly one modified operation. If m ¡Ù n, you do not have to consider the delete operation. Just consider the insert operation in T.
 * </pre>
 * 
 * 
 */
public class Solution
{
	public boolean isOneEditDistance(String s, String t)
	{
		int m = s.length();
		int n = t.length();

		// always keep m smaller than n
		if (m > n)
			return isOneEditDistance(t, s);

		if (n - m > 1)
			return false;

		int shift = n - m;
		int i = 0;
		while (i < m && s.charAt(i) == t.charAt(i))
			i++;

		// if two string are the same (shift==0), return false
		if (i == m)
			return (shift > 0);

		if (shift == 0)
			i++;
		while (i < m && s.charAt(i) == t.charAt(i + shift))
			i++;

		return i == m;
	}
}
