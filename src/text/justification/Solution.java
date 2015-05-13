package text.justification;

import java.util.ArrayList;

/**
 * Given an array of words and a length L, format the text such that each line
 * has exactly L characters and is fully (left and right) justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many words
 * as you can in each line. Pad extra spaces ' ' when necessary so that each
 * line has exactly L characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible. If
 * the number of spaces on a line do not divide evenly between words, the empty
 * slots on the left will be assigned more spaces than the slots on the right.
 * 
 * For the last line of text, it should be left justified and no extra space is
 * inserted between words.
 * 
 * <pre>
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 * 
 * Return the formatted lines as:
 * 
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * 
 * Note: Each word is guaranteed not to exceed L in length.
 * 
 * click to show corner cases.
 * Corner Cases:
 * 
 *     A line other than the last line might contain only one word. What should you do in this case?
 *     In this case, that line should be left-justified.
 * </pre>
 */

public class Solution
{
	public ArrayList<String> fullJustify(String[] words, int L)
	{
		ArrayList<String> ret = new ArrayList<String>();
		if (words == null || words.length == 0)
			return ret;

		int count = words.length;
		int p = 0;

		int beginIndex = 0;
		int currentLen = 0;
		int wordCount = 0;

		while (p < count)
		{
			String item = words[p];

			int testLen = currentLen;
			if (testLen == 0)
				beginIndex = p;

			testLen = testLen + item.length();
			if (testLen + wordCount <= L)
			{
				if (p == count - 1)
				{
					StringBuffer sb = new StringBuffer();
					for (int i = beginIndex; i <= p; i++)
					{
						sb.append(words[i]);
						if (i < p)
							sb.append(' ');
					}
					currentLen = testLen + wordCount;
					for (int j = 0; j < L - currentLen; j++)
						sb.append(' ');

					ret.add(sb.toString());
					break;
				}

				currentLen = testLen;
				p++;
				wordCount++;
				continue;
			}

			// get one result here.

			int spaces = L - currentLen;

			int minSpace = 0;
			if (wordCount > 1)
				minSpace = spaces / (wordCount - 1);
			else
				minSpace = spaces;

			int adjust = 0;
			if (wordCount > 1)
				adjust = spaces % (wordCount - 1);

			StringBuffer sb = new StringBuffer();
			sb.append(words[beginIndex]);

			if (wordCount == 1)
			{
				for (int j = 0; j < minSpace; j++)
					sb.append(' ');
			}
			for (int i = beginIndex + 1; i < p; i++)
			{
				for (int j = 0; j < minSpace; j++)
					sb.append(' ');
				if (adjust > 0)
				{
					adjust--;
					sb.append(' ');
				}
				sb.append(words[i]);
			}

			ret.add(sb.toString());

			currentLen = 0;
			wordCount = 0;
		}

		return ret;
	}
}