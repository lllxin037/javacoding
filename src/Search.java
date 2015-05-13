import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Search
{
	static List<Integer> sundayMatch(String str, String pattern)
	{
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		int len_t = str.length();
		int len_m = pattern.length();

		// initialize the map
		for (int i = 0; i < pattern.length(); i++)
		{
			map.put(pattern.charAt(i), i);
		}

		List<Integer> matchPos = new ArrayList<Integer>();
		int pos = 0;
		while (pos < len_t - len_m + 1)
		{ 
			int j = 0;

			for (; j < len_m; ++j)
			{
				char strChar = str.charAt(pos + j);
				char patternChar = pattern.charAt(j);

				if (strChar != patternChar)
				{
					if (pos + len_m + 1 < len_t
							&& map.get(str.charAt(pos + len_m + 1)) == null)
					{
						pos += len_m;
					}
					else
					{
						pos = pos + len_m + 1 - map.get(str.charAt(pos + len_m + 1));
					}
					break;
				}
			}

			if (j == len_m)
			{
				matchPos.add(pos);
				pos++;
			}
		}
		return matchPos;
	}

	public static void main(String[] args)
	{
		String source = "jello ah ah adolf adfsadfklf adf234masdfsdfdsfdsfdsffwerwrewrerwerwersdf2666sdflsdfk";
		String pattern = "adf";

		long begin = System.nanoTime();
		// System.out.println("NormalMatch:" + sundySearch.normalMatch());
		// System.out.println("NormalMatch:" + (System.nanoTime() - begin));
		//
		// sundySearch.currentPos = 0;
		//
		// begin = System.nanoTime();
		System.out.println("SundayMatch:" + sundayMatch(source, pattern));
		System.out.println("SundayMatch:" + (System.nanoTime() - begin));

	}
}