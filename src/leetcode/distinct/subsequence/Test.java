package leetcode.distinct.subsequence;


public class Test
{

	private static void oneCase(String S, String T)
	{
		System.out.println("#########################");
		Solution s = new Solution();

		System.out.println( s.numDistinct(S, T) );
		System.out.println("#########################\n\n");
	}
	
	static void dumpArray(int[] values)
	{
		for (int i = 0; i < values.length; i++)
		{
			System.out.print(values[i] + "  ");
		}
		
		System.out.println("");
	}

	
	public static void main(String args[])
	{
		/*oneCase("ABCDE", "ACE");
		oneCase("ABCDE", "AEC");
		
		oneCase("BBB", "BB");
		oneCase("rbbb", "rbb");*/
		
		oneCase("rabbit", "bit");
	}
}
