

import java.util.HashMap;
import java.util.Map;

public class TinyURL
{
	private Map<Integer, Character> init()
	{
		Map<Integer, Character> map = new HashMap<Integer, Character>();
		for (int i = 0; i <= 9; i++)
			map.put(i, (char) ('0' + i));
		for (int i = 0; i <= 25; i++)
			map.put(i + 10, (char) ('a' + i));
		for (int i = 0; i <= 25; i++)
			map.put(i + 36, (char) ('A' + i));

		return map;
	}

	public String produce(int id, int base, Map<Integer, Character> map)
	{
		StringBuilder sb = new StringBuilder();
		while (id > 0)
		{
			int key = id % base;
			char c = map.get(key);
			sb.append(c);
			id = id / base;
		}

		while (sb.length() < 6)
			sb.append('0');

		return sb.reverse().toString();
	}

	public int resolve(String s, int base)
	{
		int ret = -1;

		if (s.length() != 6)
			return ret;

		ret = 0;
		for (int index = 0; index < 6; index++)
		{
			char c = s.charAt(index);
			if (c >= '0' && c <= '9')
				ret = ret * base + (c - '0');
			else if (c >= 'a' && c <= 'z')
				ret = ret * base + (c - 'a' + 10);
			else if (c >= 'A' && c <= 'Z')
				ret = ret * base + (c - 'A' + 36);
		}

		return ret;
	}

	public static void main(String[] args)
	{
		TinyURL s1 = new TinyURL();
		Map map = s1.init();
		System.out.println("Produce tiny url "
				+ s1.produce(125, map.size(), map));
		System.out.println("Produce tiny url "
				+ s1.produce(19158, map.size(), map));

		System.out.println("Resolve URL to index " + s1.resolve("000021", 62));
		System.out.println("Resolve URL to index " + s1.resolve("0004Z0", 62));		
	}
}
