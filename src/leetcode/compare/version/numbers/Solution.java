package leetcode.compare.version.numbers;

public class Solution
{
	public int compareVersion(String version1, String version2)
	{
		if (version1 == null || version1.isEmpty())
			return ((version2 == null || version2.isEmpty()) ? 0 : -1);

		if (version2 == null || version2.isEmpty())
			return ((version1 == null || version1.isEmpty()) ? 0 : 1);

		int i = 0, j = 0;
		while (i < version1.length() && j < version2.length())
		{
			int i1 = i, j1 = j;
			while (i1 < version1.length() && version1.charAt(i1) != '.')
				i1++;
			while (j1 < version2.length() && version2.charAt(j1) != '.')
				j1++;

			Integer v1 = Integer.valueOf(version1.substring(i, i1));
			Integer v2 = Integer.valueOf(version2.substring(j, j1));
			if (v1.compareTo(v2) != 0)
				return v1.compareTo(v2);

			i = Math.min(i1 + 1, version1.length());
			j = Math.min(j1 + 1, version2.length());
		}

		if (i == version1.length())
		{
			while (j < version2.length()
					&& (version2.charAt(j) == '.' || version2.charAt(j) == '0'))
				j++;

			return (j == version2.length() ? 0 : -1);
		}

		if (j == version2.length())
		{
			while (i < version1.length()
					&& (version1.charAt(i) == '.' || version1.charAt(i) == '0'))
				i++;

			return (i == version1.length() ? 0 : 1);
		}

		return 0;
	}

}
