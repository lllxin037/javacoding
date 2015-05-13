package leetcode.wordbreakII;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Solution1 {

	public List<String> wordBreak(String s, Set<String> dict) {

		List<List<Integer>> dp = new ArrayList<>(s.length());
		for (int i = 0; i < s.length(); i++)
			dp.add(null);

		for (int i = 0; i < s.length(); i++) {

			for (int j = 0; j <= i; j++) {

				String sub = s.substring(j, i + 1);
				if (dict.contains(sub) && (j == 0 || dp.get(j - 1) != null)) {
					if (dp.get(i) == null)
						dp.set(i, new ArrayList<Integer>());

					dp.get(i).add(j - 1);
				}
			}
		}

		List<String> ret = new ArrayList<>();
		backtrace(dp, s, s.length() - 1, "", ret);

		return ret;
	}

	private void backtrace(List<List<Integer>> dp, String s, int startIndex,
			String one, List<String> ret) {

		List<Integer> indices = dp.get(startIndex);
		if (indices == null)
			return;

		for (int index : indices) {

			// check reach the beginning of string .
			String sub = s.substring(index + 1, startIndex + 1);
			if (index == -1) {
				ret.add(sub + (one.isEmpty() ? "" : " ") + one);
			}
			else
				backtrace(dp, s, index, sub + (one.isEmpty() ? "" : " ") + one,
						ret);
		}
	}
}
