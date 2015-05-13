package leetcode.repeated.dna.sequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public List<String> findRepeatedDnaSequences(String s) {

		if (s == null || s.length() <= 10)
			return Collections.<String> emptyList();

		List<String> ret = new ArrayList<>();
		Map<Integer, Integer> visited = new HashMap<>();

		int curVal = getBit(s.charAt(0));
		for (int i = 1; i < 10; i++) {
			curVal = curVal << 2;
			curVal = curVal + getBit(s.charAt(i));
		}
		visited.put(curVal, 1);

		int mask = 0xFFFFF;
		for (int i = 10; i < s.length(); i++) {
			curVal = curVal << 2;
			curVal = curVal & mask;

			curVal = curVal + getBit(s.charAt(i));
			Integer counter = visited.get(curVal);
			if (counter == null)
				visited.put(curVal, 1);
			else if (counter == 1) {
				ret.add(s.substring(i - 9, i + 1));
				visited.put(curVal, -1);
			}

		}

		return ret;
	}

	private byte getBit(char c) {
		switch (c)
		{
		case 'A':
			return 0;
		case 'C':
			return 1;
		case 'G':
			return 2;
		case 'T':
			return 3;
		default:
			return -1;
		}
	}
}