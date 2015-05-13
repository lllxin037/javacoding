package leetcode.add.binary;

/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * <pre>
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 * </pre>
 * 
 */

public class Solution
{
	public String addBinary(String a, String b)
	{
		if (a == null)
			return b;
		if (b == null)
			return a;

		int aLen = a.length();
		int bLen = b.length();

		int minLen = Math.min(aLen, bLen);
		StringBuffer sb = new StringBuffer();

		int extra = 0;
		for (int i = 1; i <= minLen; i++)
		{
			int a1 = a.charAt(aLen - i) == '1' ? 1 : 0;
			int b1 = b.charAt(bLen - i) == '1' ? 1 : 0;

			int oneResult = a1 + b1 + extra;
			sb.insert(0, oneResult & 1);
			extra = ( oneResult & 2 ) >> 1;
		}

		if (aLen == bLen)
		{
			if (extra == 1)
				sb.insert(0, 1);
			
			return sb.toString();
		}

		String remaining = a;
		if (bLen > aLen)
			remaining = b;

		int maxLen = Math.max(aLen, bLen);
		for (int i = maxLen - minLen - 1; i >= 0; i--)
		{
			int r1 = remaining.charAt(i) == '1' ? 1 : 0;
			int oneResult = r1 + extra;
			sb.insert(0, oneResult & 1);
			extra = (oneResult & 2) >> 1;
		}

		if (extra == 1)
			sb.insert(0, 1);
		
		return sb.toString();
	}
}