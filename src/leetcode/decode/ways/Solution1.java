package leetcode.decode.ways;

public class Solution1 {

	public int numDecodings(String s) {

		if (s == null || s.isEmpty() || s.charAt(0) == '0')
			return 0;

		int a = 1;
		int b = 1;

		for (int i = 1; i < s.length(); i++) {

			int n = 0;

			if (s.charAt(i) == '0') {
				if (s.charAt(i - 1) < '1' || s.charAt(i - 1) > '2')
					return 0;
				else
					n = a;
			}
			else if ((s.charAt(i) <= '6' && s.charAt(i - 1) == '2')
					|| s.charAt(i - 1) == '1')
				n = a + b;
			else
				n = b;

			a = b;
			b = n;
		}

		return b;
	}

}
