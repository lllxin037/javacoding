package leetcode.decode.ways;

public class Test
{
	private static void oneCase(String s)
	{
		System.out.println("#########################");
		Solution1 s1 = new Solution1();
		System.out.println(s + "\t" + s1.numDecodings(s));

		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		/*oneCase(null);
		oneCase(""); 

		oneCase("000");*/

		oneCase("12");
		oneCase("120");
		oneCase("123");
		oneCase("30");
		oneCase("127");

		oneCase("1210");
		
		oneCase("1111");
		oneCase("101");
		oneCase("2201");
		oneCase("012");
		
		oneCase("100");
		oneCase("230");
		oneCase("20130");
		
		oneCase("611");
		
		oneCase("1212");
		

		oneCase("4757562545844617494555774581341211511296816786586787755257741178599337186486723247528324612117156948");
	}
}
