package leetcode.valid.palindrome;

/**
 * 
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * <pre>
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * </pre>
 * 
 * Note: Have you consider that the string might be empty? This is a good
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 * 
 * 
 */

public class Solution
{
	public boolean isPalindrome(String s)
	{
		int start = 0;
		int end = s.length() -1;

		String newS = s.toLowerCase();
		while (start < end)
		{
			char sChar = newS.charAt(start);
			while ( !(sChar <= '9' && sChar >= '0')
					&& !(sChar <= 'z' && sChar >= 'a') && start < end )
			{
				start++;
				sChar = newS.charAt(start);
			}
			
			char eChar = newS.charAt(end);
			while (!(eChar <= '9' && eChar >= '0')
					&& !(eChar <= 'z' && eChar >= 'a') && start < end )
			{
				end--;
				eChar = newS.charAt(end);
			}
			
			if (start == end)
				return true;
			
			if (sChar != eChar)
				return false;
			
			start++;
			end--;
		}

		return true;
	}
}