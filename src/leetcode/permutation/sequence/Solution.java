package leetcode.permutation.sequence;

import java.util.ArrayList;
import java.util.List;

/**
 * The set [1,2,3,бн,n] contains a total of n! unique permutations.
 * 
 * <pre>
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * 
 *     "123"
 *     "132"
 *     "213"
 *     "231"
 *     "312"
 *     "321"
 * 
 * Given n and k, return the kth permutation sequence.
 * </pre>
 * 
 * Note: Given n will be between 1 and 9 inclusive.
 * 
 */
public class Solution
{
	public String getPermutation(int n, int k)
	{
		int[] combinations = new int[n];
		combinations[0] = 0;
		if (n > 1)
			combinations[1] = 1;
		for (int i = 2; i < n; i++)
			combinations[i] = combinations[i - 1] * i;

		if (k < 1 || (n > 1 && k > combinations[n - 1] * n) || (n == 1 && k > 1))
			return null;

		StringBuffer sb = new StringBuffer();
		List<Integer> p = new ArrayList<Integer>();
		p.add(0);
		for (int i = 1; i <= n; i++)
			p.add(i);

		int m = k;
		for (int i = n - 1; i >= 1; i--)
		{
			int v = p.size() - 1;
			if (m > 0)
				v = (m + combinations[i] - 1) / combinations[i];

			sb.append(p.get(v));
			p.remove(v);

			m = m % combinations[i];
		}

		if (p.size() == 2)
			sb.append(p.get(1));

		return sb.toString();
	}
}