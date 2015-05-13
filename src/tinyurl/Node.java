package tinyurl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Node
{
	private String name;
	private Map<Long, String> cachedURL = new HashMap<Long, String>();

	public Node(String name)
	{
		this.name = name;
	}

	public String getURL(long key)
	{
		return cachedURL.get(key);
	}

	public void putURL(long key, String longURL)
	{
		cachedURL.put(key, longURL);
	}

	public String getName()
	{
		return name;
	}

	public String toString()
	{
		return getName();
	}

	protected void dump()
	{
		System.out.println("###########################\n" + name);
		Set<Long> keys = cachedURL.keySet();
		Iterator<Long> iter1 = keys.iterator();
		while (iter1.hasNext())
		{
			Long one = iter1.next();
			System.out.println("key : " + one + "\t" + cachedURL.get(one));
		}
	}
	
}
