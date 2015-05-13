package leetcode.valid.number;

/**
 * Validate if a given string is numeric.
 * 
 * <pre>
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * </pre>
 * 
 * Note: It is intended for the problem statement to be ambiguous. You should
 * gather all requirements up front before implementing one.
 * 
 */
public class Solution
{
	public boolean isNumber(String s)
	{
		if (s == null)
			return false;

		String t = s.trim();
		if (t.isEmpty())
			return false;

		boolean cane = false;
		boolean canpoint = true;
		boolean cansign = true;
		boolean havenumber = false;
		boolean hase = false;
		
		int i = 0;
		while (i < t.length())
		{
			char c = t.charAt(i);
			if (c == '+' || c == '-')
			{
				if (!cansign)
					return false;
				cansign = false;
			}
			else if (c == 'e')
			{
				if (!cane)
					return false;
				cane = false;		
				hase = true;
				cansign = true;
				canpoint = false;
				havenumber = false;
			}
			else if (c >= '0' && c <= '9')
			{
				cansign = false;				
				havenumber = true;
				if (!hase) cane = true;
			}
			else if (c == '.')
			{
				if (!canpoint)
					return false;
				canpoint = false;
				cansign = false;
			}
			else
				return false;
			
			i++;
		}

		return havenumber;

	}
}
