package leetcode.longest.consecutive;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * For example,
 * 
 * <pre>
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * </pre>
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 */

public class Solution
{
	/**
	 */
	
	public int longestConsecutive(int[] num)
	{
		if (num == null || num.length == 0)
			return 0;

		int maxValue = 1;
		
		Map<Integer, UpperAndLower> maps = new LinkedHashMap<Integer, UpperAndLower>();
		
		for (int i = 0; i < num.length; i++)
		{
			// duplicated values. Ignore.
			UpperAndLower lenObj = maps.get(num[i]);
			if (lenObj != null)
				continue;

			maps.put(num[i], new UpperAndLower(1, 1));
			
			int lowerBound = num[i];
			int upperBound = num[i];
			
			UpperAndLower preObj = maps.get(num[i] -1);
			if (preObj != null)
			{				
				lowerBound = (num[i]-1) - preObj.lower + 1;
			}				
			UpperAndLower nextObj = maps.get(num[i] + 1);
			if (nextObj != null)
			{
				upperBound = ( num[i] + 1) + nextObj.upper - 1;
			}
			
			int range = upperBound - lowerBound + 1;
			
			
			Test.dump(maps, upperBound, lowerBound);
			System.out.println(num[i] + " expand to upperBound " + upperBound + " with range: " + range);
			System.out.println(num[i] + " expand to lowerBound " + lowerBound + " with range: " + range);
			maps.put(upperBound, new UpperAndLower(1, range));
			maps.put(lowerBound, new UpperAndLower(range, 1));
			
			if (range > maxValue)
				maxValue = range;
		}
		
		return maxValue;
	}
	
	protected static class UpperAndLower
	{
		//The sequence start by this value;
		protected int upper = 0;
		
		//The sequence end by this value;
		protected int lower = 0;
		
		public UpperAndLower(int upper, int lower)
		{
			this.upper = upper;
			this.lower = lower;
		}
	}
	
}