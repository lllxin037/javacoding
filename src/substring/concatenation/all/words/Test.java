package substring.concatenation.all.words;

import java.util.List;

public class Test
{
	private static void oneCase(String S, String[] L)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		List<Integer> matched = s1.findSubstring(S, L);
		System.out.println(matched);
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		/**/
		oneCase("barfoothefoobarman", new String[]
		{ "foo", "bar" });

		oneCase("lingmindraboofooowingdingbarrwingmonkeypoundcake",
				new String[]
				{ "fooo", "barr", "wing", "ding", "wing" });

		oneCase("aaa", new String[]
		{ "a", "a" }); 

		// Output: [0,1,2,3,4]
		// Expected: [0,2,4]
		oneCase("abababab", new String[]
		{ "a", "b", "a" });
	}
}
