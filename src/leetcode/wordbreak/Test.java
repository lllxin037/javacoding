package leetcode.wordbreak;

import java.util.HashSet;
import java.util.Set;

public class Test
{

	private static Set<String> getDict(String[] ss)
	{
		Set<String> ret = new HashSet<String>();
		for (int i = 0; i < ss.length; i++)
		{
			ret.add(ss[i]);
		}
		
		return ret;
	}
	
	public static void main(String[] args)
	{
		Solution s = new Solution();
		
		String[] s1 = {"leet","code"};
		System.out.println(s.wordBreak("leetcode", getDict(s1) ));
		
		String[] s2 = {"car","ca", "rs"};
		System.out.println(s.wordBreak("cars", getDict(s2) ));
		
		String[] s3 = {"c","rs", "ca"};
		System.out.println(s.wordBreak("cars", getDict(s3) ));
		
		String[] s4 = {"c","rs"};
		System.out.println(s.wordBreak("cars", getDict(s4) ));
		
	}
}
