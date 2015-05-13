package leetcode.gas.station;

public class Test
{
	private static int onecase(int[] gas, int[] cost)
	{
		Solution s = new Solution();		
		return s.canCompleteCircuit(gas, cost);
	}
	
	public static void main(String[] args)
	{
		System.out.println( onecase(new int[]{1}, new int[]{1}) );		
		
		System.out.println( onecase(new int[]{3,2,1}, new int[]{2,1,1}) );
		
		System.out.println( onecase(new int[]{1,3,1}, new int[]{2,1,1}) );
		
		System.out.println( onecase(new int[]{1,1,3}, new int[]{1,2,1}) );
	}
}
