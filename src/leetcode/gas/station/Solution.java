package leetcode.gas.station;

/**
 * 
 * here are N gas stations along a circular route, where the amount of gas at
 * station i is gas[i].
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
 * travel from station i to its next station (i+1). You begin the journey with
 * an empty tank at one of the gas stations.
 * 
 * Return the starting gas station's index if you can travel around the circuit
 * once, otherwise return -1.
 * 
 * Note: The solution is guaranteed to be unique.
 * 
 */
public class Solution
{
	public int canCompleteCircuit(int[] gas, int[] cost)
	{
		int len = gas.length;
		
		for (int i = 0; i < len; i++)
		{		
			int remain = 0;
			int j = 0;
			
			boolean failed = false;
			for (; j < len; j++)
			{			
				int index = i + j;
				if (index >= len)
					index = index - len;
				
				remain = gas[index] + remain - cost[index];
				if (remain < 0)
				{
					failed = true;
					break;
				}
			}

			
			if (!failed)
				return i;
		}
		
		return -1;
	}
}
