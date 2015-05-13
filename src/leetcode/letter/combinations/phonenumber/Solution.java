package leetcode.letter.combinations.phonenumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a digit string, return all possible letter combinations that the number
 * could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below.
 * 
 * <pre>
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * </pre>
 * 
 * Note: Although the above answer is in lexicographical order, your answer
 * could be in any order you want.
 * 
 */

public class Solution
{
	public List<String> letterCombinations(String digits)
	{
		List<String> combinations = new ArrayList<String>();
		if (digits == null )
			return combinations;

		if ( digits.isEmpty())
		{
			combinations.add("");
			return combinations;
		}
		
		Map<Integer, char[]> mapping = createMapping();
		for (int i = 0; i < digits.length(); i++)
		{
			char[] letters = mapping.get(digits.charAt(i) - '0');
			int oldSize = combinations.size();
			if (oldSize == 0 && letters != null)
			{
				for (int k = 0; k < letters.length; k++)
					combinations.add(String.valueOf(letters[k]));

				continue;
			}

			List<String> tmp = new ArrayList<String>();
			for (int j = 0; letters != null && j < oldSize; j++)
			{
				String sb = combinations.get(j);
				for (int k = 0; k < letters.length; k++)
					tmp.add(sb + letters[k]);
			}

			combinations = tmp;
		}

		return combinations;
	}

	private Map<Integer, char[]> createMapping()
	{
		Map<Integer, char[]> mapping = new HashMap<Integer, char[]>();
		mapping.put(2, new char[]
		{ 'a', 'b', 'c' });
		mapping.put(3, new char[]
		{ 'd', 'e', 'f' });
		mapping.put(4, new char[]
		{ 'g', 'h', 'i' });
		mapping.put(5, new char[]
		{ 'j', 'k', 'l' });
		mapping.put(6, new char[]
		{ 'm', 'n', 'o' });
		mapping.put(7, new char[]
		{ 'p', 'q', 'r', 's' });
		mapping.put(8, new char[]
		{ 't', 'u', 'v' });
		mapping.put(9, new char[]
		{ 'w', 'x', 'y', 'z' });
		mapping.put(0, new char[]
		{ ' ' });

		return mapping;
	}
}