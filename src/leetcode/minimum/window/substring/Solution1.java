package leetcode.minimum.window.substring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {

	public String minWindow(String S, String T) {

		if (S == null || T == null)
			return null;

		if (T.isEmpty() || S.isEmpty())
			return "";

		Map<Character, Integer> toFind = new HashMap<Character, Integer>();
		Map<Character, Integer> found = new HashMap<Character, Integer>();

		for (int i = 0; i < T.length(); i++) {
			char c = T.charAt(i);
			
			found.put(c, 0);
			if (!toFind.containsKey(c))
				toFind.put(c, 1);
			else
				toFind.put(c, toFind.get(c) + 1);
		}

		int left = 0;
		int right = 0;
		String ret = "";

		int minWin = Integer.MAX_VALUE;
		int matched = 0; // keep the number to match the length of T.

		List<Integer> matchedIndices = new ArrayList<Integer>();

		while (right < S.length()) {

			char c = S.charAt(right);
			if (!toFind.containsKey(c)) {
				right++;
				continue;
			}

			matchedIndices.add(right);

			found.put(c, found.get(c) + 1);
			if (found.get(c) <= toFind.get(c))
				matched++;

			right++;

			if (matched >= T.length()) { // retrospect & shrink the windows
				char leftChar = S.charAt(matchedIndices.get(left));
				while (found.get(leftChar) > toFind.get(leftChar)) {
					found.put(leftChar, found.get(leftChar) - 1);
					left++;
					leftChar = S.charAt(matchedIndices.get(left));
				}
				if (right - matchedIndices.get(left) < minWin) {
					minWin = right - matchedIndices.get(left);
					ret = S.substring(matchedIndices.get(left), right);
				}
			}

		}

		return ret;
	}
}
