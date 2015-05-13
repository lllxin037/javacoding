package leetcode.maximal.rectangle;

public class Test
{
	private static void oneCase(char[][] values)
	{
		System.out.println("#########################");
		Solution1 s1 = new Solution1();

		System.out.println(s1.maximalRectangle(values));

		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{

		oneCase(new char[][]
		{
		{ '1', '0', '1' },
		{ '1', '1', '1' },
		{ '1', '1', '1' } });

		
		oneCase(new char[][]{{'0','1'}});
		
		oneCase(new char[][]{{'0','1'},{'0','1'}});
		/*oneCase(new char[][]
		{
		{ '0', '1' },
		{ '1', '0' }, }); */

		oneCase(new char[][]
		{
		{ '1', '0', '1' },
		{ '1', '1', '0' },
		{ '1', '1', '1' } });
		
		oneCase(new char[][]
		{
		{ '1', '0', '1', '0' },
		{ '1', '1', '1', '1' },
		{ '1', '1', '1', '1' } }); 
	}
}
