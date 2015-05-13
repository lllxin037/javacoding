package leetcode.surrounded.regions;


public class Test
{

	private static void oneCase(String s)
	{
		System.out.println("#####################");
		Solution sol = new Solution();
		
		char[][] board = createBoard(s);
		sol.solve(board);		
		dumpBoard(board);
		System.out.println("#####################\n\n");		
	}
	
	private static char[][] createBoard(String s)
	{
		String[] values = s.split(",");
		char[][] ret = new char[values.length][values[0].length()];
		
		for (int i = 0; i < values.length; i++)
		{
			String one = values[i];
			for (int j = 0; j < one.length(); j++)
			{
				ret[i][j] = one.charAt(j);
			}
		}
		
		return ret;
	}
	
	private static void dumpBoard(char[][] board)
	{
		for (int i = 0; i < board.length; i++)
		{
			char[] one = board[i];
			for (int j = 0; j < one.length; j++)
			{
				System.out.print(one[j] + " ");
			}
			System.out.print("\n");
		}
	}

	public static void main(String[] args)
	{
		oneCase("");		
	 	oneCase("OOO,OOO,OOO");
		oneCase("XXXX,XOOX,XXOX,XOXX");		
		oneCase("OOOOOOOOOOO,OXXXXXXXXXO,OXOOOOOOOXO,OXOOOOOOOXO,OXOOOOOOOXO,OXOOOOOOOXO,OXOOOOOOOXO,OXXXXXXXXXO,OOOOOOOOOOO");
	}
}
