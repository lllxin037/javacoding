package leetcode.pascal.triangleII;



public class Test
{
	private static void oneCase(int rowIndex)
	{
		System.out.println("#########################");
		Solution s = new Solution();
		System.out.println( s.getRow(rowIndex));
		System.out.println("#########################\n\n");
	}

	public static void main(String[] args)
	{ 
		oneCase(0);
		oneCase(1);
		oneCase(2);
		oneCase(3);
		oneCase(4);
		oneCase(10);			
	}
	
}
