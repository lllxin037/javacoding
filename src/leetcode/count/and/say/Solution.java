package leetcode.count.and.say;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 
 * <pre>
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * </pre>
 * 
 * Given an integer n, generate the nth sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 * 
 * 
 */
public class Solution
{
	public String countAndSay(int n)
	{
		String value = "1";
		if (n <= 1)
			return value;

		StringBuffer sb = new StringBuffer();
		for (int i = 2; i <= n; i++)
		{
			int cur = 0;
			int count = 1;

			while (cur < value.length())
			{
				if (cur + 1 >= value.length()
						|| value.charAt(cur) != value.charAt(cur + 1))
				{
					sb.append(count);
					sb.append(value.charAt(cur));
					count = 1;
					cur++;
				}
				else{
					count++;
					cur++;
				}
			}

			
			value = sb.toString();
			sb.setLength(0);
		}

		return value;
	}
}