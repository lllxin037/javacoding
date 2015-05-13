package leetcode.restore.ip.addresses;

import java.util.ArrayList;

public class Test
{
	private static void oneCase(String s)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		ArrayList<String> ret = s1.restoreIpAddresses(s);
		for (int i = 0; i < ret.size(); i++)
		{
			System.out.println(ret.get(i));
		}

		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase("25525511135");
		oneCase("1111");
		
		oneCase("12111");
		
		oneCase("010010");
		
	}
}
