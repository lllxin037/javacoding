package leetcode.excel.sheet.column;

public class Solution
{
	public String convertToTitle(int n)
	{
		StringBuilder sb = new StringBuilder();

		while (n > 0)
		{
			int reminder = n % 26;
			char c = 'Z';
			if (reminder != 0)
				c = (char) (reminder + 'A' - 1);

			sb.insert(0, c);
			n = n / 26;
			if (reminder == 0)
				n--;
		}

		return sb.toString();
	}
}
