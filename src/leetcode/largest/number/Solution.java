package leetcode.largest.number;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange them such that they form the
 * largest number.
 * 
 * <pre>
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * 
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * </pre>
 * 
 */

public class Solution {

	public String largestNumber(int[] num) {

		if (num == null || num.length == 0)
			return null;

		Integer[] numObjs = new Integer[num.length];
		for (int i = 0; i < num.length; i++)
			numObjs[i] = Integer.valueOf(num[i]);

		Arrays.sort(numObjs, new Comparator<Integer>() {
			public int compare(Integer one, Integer two) {
				String tmp1 = String.valueOf(one) + String.valueOf(two);
				String tmp2 = String.valueOf(two) + String.valueOf(one);

				int n = tmp1.length();
				for (int i = 0; i < n; i++) {
					if (tmp1.charAt(i) != tmp2.charAt(i))
						return (tmp1.charAt(i) - tmp2.charAt(i) > 0 ? 1 : -1);
				}

				return 0;
			}
		});

		if (numObjs[numObjs.length - 1] == 0)
			return "0";

		StringBuilder sb = new StringBuilder();
		for (int i = numObjs.length - 1; i >= 0; i--) {
			sb.append(numObjs[i].intValue());
		}

		return sb.toString();
	}
}
