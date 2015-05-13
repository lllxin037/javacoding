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

public class ReverseSolution
{
	public boolean isPalindrome(int x)
	{
		if (x < 0)
			return false;

		if (x < 10)
			return true;

		int reverse = 0;
		int original = x;

		while (x > 0)
		{
			int oneDigit = x % 10;
			reverse = reverse * 10 + oneDigit;

			x = x / 10;
		}

		return (reverse == original);
	}
}