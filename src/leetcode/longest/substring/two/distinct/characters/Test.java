package leetcode.longest.substring.two.distinct.characters;

public class Test
{
	private static void oneCase(String s)
	{
		Solution1 sol = new Solution1();
		System.out.println(sol.lengthOfLongestSubstringTwoDistinct(s));
	}

	public static void main(String[] args)
	{				
		oneCase("ececba");
		oneCase("ecccba");
		oneCase("ecccea");
		oneCase("ccccca");
		oneCase("cccccc");
		
		oneCase("aabadefghaabbaagad");		
	}
}
