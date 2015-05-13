package leetcode.permutations.ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1 {

	public List<List<Integer>> permuteUnique(int[] num) {

		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (num.length == 0)
			return ret;
		if (num.length == 1) {
			List<Integer> one = new ArrayList<Integer>();
			one.add(num[0]);
			ret.add(one);
			return ret;
		}

		Arrays.sort(num);
		Set<Integer> visited = new HashSet<Integer>();
		for (int i = 0; i < num.length; i++) {
			if (visited.contains(num[i]))
				continue;

			int[] newnum = new int[num.length - 1];
			for (int j = 0; j < i; j++)
				newnum[j] = num[j];
			for (int j = i + 1; j < num.length; j++)
				newnum[j - 1] = num[j];

			for (List<Integer> one : permuteUnique(newnum)) {
				one.add(num[i]);
				ret.add(one);
			}

			visited.add(num[i]);
		}

		return ret;
	}
}
