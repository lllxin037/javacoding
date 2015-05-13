package single.numberII;

/**
 * Given an array of integers, every element appears three times except for one.
 * Find that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 */

public class Solution
{
	public int singleNumber(int[] A)
	{
		//
		int ret = 0;
		int[] bits = new int[32];

		// calculate all bits
		for (int j = 0; j < bits.length; j++)
		{
			for (int i = 0; i < A.length; i++)
			{
				bits[j] = (bits[j] + (A[i] >> j & 0x1)) % 3;
			}

			if (bits[j] != 0)
				ret = ret | (1 << j);
		}
		
		return ret;
	}
}
