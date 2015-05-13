package leetcode.word.ladderII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution1 {

	public ArrayList<ArrayList<String>> findLadders(String start, String end,
			HashSet<String> dict) {

		ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
		if (dict.isEmpty())
			return ret;

		if (start.equals(end)) {
			return ret;
		}

		Queue<String> words = new LinkedList<String>();
		Map<String, Set<String>> map = new HashMap<String, Set<String>>();
		Set<String> visited = new HashSet<String>();
		Set<String> curLevelVisited = new HashSet<String>();

		words.offer(start);
		words.offer(null);

		visited.add(start);

		int n = start.length();

		boolean found = false;

		while (!words.isEmpty()) {

			String one = words.poll();
			if (one == null) {
				if (found)
					break;

				visited.addAll(curLevelVisited);
				curLevelVisited.clear();
				words.offer(null);
				continue;
			}

			char[] arr = one.toCharArray();

			for (int i = 0; i < n; i++) {

				char c = arr[i];
				for (int j = 'a'; j <= 'z'; j++) {

					if ((char) j == c)
						continue;

					arr[i] = (char) j;
					String newOne = new String(arr);
					arr[i] = c; // restore the original char array

					if (end.equals(newOne)) {
						found = true;
					}
					else if (!dict.contains(newOne))
						continue;

					if (visited.contains(newOne)) {
						continue;
					}

					if (curLevelVisited.add(newOne))
						words.offer(newOne);

					Set<String> ladder = map.get(newOne);
					if (ladder == null) {
						ladder = new HashSet<String>();
						map.put(newOne, ladder);
					}
					ladder.add(one);
				}
			}
		}

		ArrayList<String> oneresult = new ArrayList<String>();
		backtrace(map, ret, end, start, oneresult);

		return ret;
	}

	private void backtrace(Map<String, Set<String>> map,
			ArrayList<ArrayList<String>> ret, String word, String start,
			ArrayList<String> oneresult) {
		if (word.equals(start)) {
			oneresult.add(0, start);
			ret.add(new ArrayList<String>(oneresult));
			oneresult.remove(0);
			return;
		}

		oneresult.add(0, word);
		if (map.get(word) != null) {
			for (String s : map.get(word)) {
				backtrace(map, ret, s, start, oneresult);
			}
		}
		oneresult.remove(0);
	}
}
