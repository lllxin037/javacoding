package leetcode.longest.substring.without.repeating.characters;

public class Test
{

	private static void oneCase(String s)
	{
		System.out.println("#####################");
		Solution sol = new Solution();
		System.out.println(sol.lengthOfLongestSubstring(s));

		System.out.println("#####################\n\n");

	}

	public static void main(String[] args)
	{
		/*
		oneCase("abcabcbb");
		oneCase("bbbbb");
		oneCase("abcd");*/
		
		//12
		oneCase("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco");
		
	}
}
