package epi.arrays;
import java.util.Random;

/**
 * Let A be an array whose entries are all distinct. Implement an algorithm that
 * takes A and an integer k and returns a subset of k elements of A. All subsets
 * should be equally likely. Use as few calls to the random number generator
 * (which returns random integers) as possible and use O(1) additional storage.
 * You can return the result in the same array as input.
 * 
 */

public class OfflineSampling
{
	public static int[] offlineSampling(int[] A, int k)
	{
		if (A == null || A.length == 0 || k < 1 || k >= A.length)
			return A;

		Random r = new Random();
		for (int i = A.length - 1; i > A.length - 1 - k; i--)
		{
			// Generate random int in [0, i]
			swap(A, i, r.nextInt(i));
		}

		// A size should be k;
		return A;
	}

	private static void swap(int[] A, int i, int j)
	{
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}

	public static void main(String[] args)
	{
		int n, k;
		Random gen = new Random();
		int[] A;

		n = gen.nextInt(1000) + 1;
		k = gen.nextInt(n) + 1;

		A = new int[n];
		for (int i = 0; i < n; ++i)
		{
			A[i] = i;
		}
		System.out.println(n + " " + k);

		int[] ans = offlineSampling(A, k);

		assert ans.length == n;
		for (int i = n - 1; i > n - 1 - k; i--)
		{
			System.out.print(ans[i] + " ");
		}
		System.out.println();
	}
}
