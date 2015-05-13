package leetcode.palindrome.number;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * click to show spoilers.
 * 
 * Some hints: Could negative integers be palindromes? (ie, -1)
 * 
 * If you are thinking of converting the integer to string, note the restriction
 * of using extra space.
 * 
 * You could also try reversing an integer. However, if you have solved the
 * problem "Reverse Integer", you know that the reversed integer might overflow.
 * How would you handle such case?
 * 
 * There is a more generic way of solving this problem.
 * 
 */

public class Solution
{
	public boolean isPalindrome(int x)
	{
		if (x < 0)
			return false;

		if (x < 10)
			return true;
		
		int highDiv = 10;
		while (x / highDiv >= 10)
			highDiv *= 10;

		int lDig = 0;
		int rDig = 0;
		while (x > 0)
		{
			lDig = x / highDiv;
			rDig = x % 10;
			if (lDig != rDig)
				return false;

			x = (x - lDig * highDiv - rDig) / 10;
			highDiv /= 100;
		}

		return true;
	}
}