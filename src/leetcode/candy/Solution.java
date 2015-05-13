package leetcode.candy;

import java.util.Arrays;

/**
 * There are N children standing in a line. Each child is assigned a rating
 * value.
 * 
 * You are giving candies to these children subjected to the following
 * requirements:
 * 
 * Each child must have at least one candy. Children with a higher rating get
 * more candies than their neighbors.
 * 
 * What is the minimum candies you must give?
 * 
 */
public class Solution
{
	public int candy(int[] ratings)
	{
		int len = ratings.length;
		
		// left to right
		int[] ltr = new int[len];		
		Arrays.fill(ltr, 1);

		for (int i = 1; i < len; i++)
		{			
			int preRating = ratings[i-1];
			int currentRating = ratings[i];
			
			int delta = 0;
			
			if (currentRating > preRating )
				delta++;
					
			if ( delta == 1)
				ltr[i] = ltr[i-1] + delta;
		}
		
		int[] rtl = new int[len];		
		Arrays.fill(rtl, 1);
		for (int i = len - 2; i >= 0; i--)
		{			
			int preRating = ratings[i+1];
			int currentRating = ratings[i];
			
			int delta = 0;
			
			if (currentRating > preRating )
				delta++;
			
			if ( delta == 1)
				rtl[i] = rtl[i+1] + delta;
		}
		
		int count = 0;
		for (int i = 0; i < len; i++)
		{
			if (ltr[i] < rtl[i])
				count += rtl[i];
			else 
				count += ltr[i];
		}
		
		return count;		
	}

}
