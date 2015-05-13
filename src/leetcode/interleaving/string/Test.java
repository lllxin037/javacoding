package leetcode.interleaving.string;

public class Test
{
	private static void oneCase(String s1, String s2, String s3)
	{
		System.out.println("#########################");
		Solution s = new Solution();
		System.out.println(s.isInterleave(s1, s2, s3));

		System.out.println("#########################\n\n");
	}

	public static void main(String[] args)
	{
		 oneCase("", "", "a"); 
		
		oneCase("a", "", "a");
		oneCase("", "a", "a");
		
		oneCase("a", "c", "ac");
		
		oneCase("ab", "bc", "babc");	 	
		
		oneCase("aabcc", "dbbca", "aadbbcbcac");
		oneCase("aabcc", "dbbca", "aadbbbaccc");
		
		oneCase("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa", "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab", "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab");
		
		oneCase("aabc", "abad", "aabadabc");
	}
}
