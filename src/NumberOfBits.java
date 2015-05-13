/**
 * http://www.cnblogs.com/graphics/archive/2010/06/21/1752421.html
 * 
 * Solutions:
 * 
 * 1. O(n). one bit by one; 2. n & (n-1), O(x) the number of 1s. 3. magic
 * numbers, 5 steps. O(1) 4. lookup table. 32 / 8 = 4. O(1)
 * 
 */

public class NumberOfBits
{
	// for 32 bit integers
	private static int parallelAlgorithm(int n)
	{
		/**
		 * <pre>
		 * 		1 0 0 0 0 1 1 1 0 1 1 0 0 1 0 1 0 1 0 0 0 0 1 1 0 0 1 0 0 0 0 1
		 * 		01  00  01  10  01  01  01  01  01  00  00  10  00  01  00  01
		 * 
		 * 		01 00 01 10 01 01 01 01 01 00 00 10 00 01 00 01
		 * 		0001  0011  0010  0010  0001  0010  0001  0001
		 * 
		 * 		0001 0011 0010 0010 0001 0010 0001 0001
		 * 		00000100  00000100  00000011  00000010
		 * 
		 * 		00000100 00000100 00000011 00000010
		 * 		0000000000001000  0000000000000101
		 * </pre>
		 */
		n = (n & 0x55555555) + ((n >> 1) & 0x55555555);
		n = (n & 0x33333333) + ((n >> 2) & 0x33333333);
		n = (n & 0x0f0f0f0f) + ((n >> 4) & 0x0f0f0f0f);
		n = (n & 0x00ff00ff) + ((n >> 8) & 0x00ff00ff);
		n = (n & 0x0000ffff) + ((n >> 16) & 0x0000ffff);

		return n;
	}

	private static int lookUpTableAlgorithm(int value)
	{

		int table[] = new int[256];

		// generate the lookup table
		for (int i = 0; i < 256; i++)
			table[i] = (i & 1) + table[i >> 1];

		int size = 32 / 8;
		int count = 0;

		/*
		 * Get sie of int program by size of operator. It makes the solution
		 * consistent for different word sizes
		 */
		for (int i = 1; i <= size && value != 0; i++)
		{
			count += table[value & 255];
			value >>= 8;
		}

		return count;
	}

	public static void main(String[] args)
	{
		System.out.println(parallelAlgorithm(0x87654321));
		System.out.println(lookUpTableAlgorithm(0x87654321));
	}

}
