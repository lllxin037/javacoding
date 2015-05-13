package leetcode.reverse.words.string;

public class Solution1
{
	public String reverseWords(String s)
	{

		if (s == null || s.length() == 0)
			return s;

		int index = s.length() - 1;
		StringBuilder sb = new StringBuilder();
		while (index >= 0 && s.charAt(index) == ' ')
			index--;

		while (index >= 0)
		{
			int lastIndex = index;
			while (index >= 0 && s.charAt(index) != ' ')
				index--;

			if (sb.length() > 0)
				sb.append(' ');

			sb.append(s.substring(index + 1, lastIndex + 1));

			while (index >= 0 && s.charAt(index) == ' ')
				index--;

		}

		return sb.toString();
	}
}
