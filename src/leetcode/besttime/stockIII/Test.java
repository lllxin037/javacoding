package leetcode.besttime.stockIII;

public class Test
{
	private static void oneCase(int[] prices)
	{
		System.out.println("#########################");
		Solution1 s = new Solution1();
		System.out.println(s.maxProfit(prices));
		System.out.println("#########################\n\n");
	}

	static void dump(int[] prices)
	{
		for (int i = 0; i < prices.length; i++)
		{
			System.out.print(prices[i] + "  " );
		}
		System.out.println("");
	}
	
	public static void main(String[] args)
	{
		/*oneCase(new int[]{ });
		
		oneCase(new int[]{ 6 });
		
		oneCase(new int[]{3,3});*/
		
		oneCase(new int[]
		{ 6, 1, 3, 2, 4, 7 });

		oneCase(new int[]
		{ 3,2,6,5,3 });
		
		oneCase(new int[]
		{ 3,2,6,5,0,3 });
		
		oneCase(new int[]
				{ 2,3,1 });
		
		oneCase(new int[]
		{3,3,5,0,0,3,1,4}); 
				
		
		
	}
}
