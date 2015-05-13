package tinyurl;

import java.util.HashMap;
import java.util.Map;

public class TinyURL
{
	private Map<Long, Character> map = null;
	private int base;

	public TinyURL()
	{
		map = init();
		base = map.size();
	}

	private Map<Long, Character> init()
	{
		Map<Long, Character> map = new HashMap<Long, Character>();
		for (int i = 0; i <= 9; i++)
			map.put(Long.valueOf(i), (char) ('0' + i));
		for (int i = 0; i <= 25; i++)
			map.put(Long.valueOf(i + 10), (char) ('a' + i));
		for (int i = 0; i <= 25; i++)
			map.put(Long.valueOf(i + 36), (char) ('A' + i));

		return map;
	}

	public String produce(long id)
	{
		StringBuilder sb = new StringBuilder();
		while (id > 0)
		{
			long key = id % base;
			char c = map.get(key);
			sb.append(c);
			id = id / base;
		}

		while (sb.length() < 6)
			sb.append('0');

		return sb.reverse().toString();
	}

	public long resolve(String s)
	{
		long ret = -1;

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

		System.out.println("Produce tiny url " + s1.produce(125));
		System.out.println("Produce tiny url " + s1.produce(19158));

		System.out.println("Resolve URL to index " + s1.resolve("000021"));
		System.out.println("Resolve URL to index " + s1.resolve("0004Z0"));
	}
}
