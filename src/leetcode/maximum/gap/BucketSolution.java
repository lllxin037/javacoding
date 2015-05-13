package leetcode.maximum.gap;

import java.util.Arrays;

public class BucketSolution
{
	public int maximumGap(int[] num)
	{
        if (num == null || num.length < 2)
            return 0;
            
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < num.length; i++)
        {
            min = Math.min(min, num[i]);
            max = Math.max(max, num[i]);
        }
        
        int gap = (max - min + num.length - 2) / (num.length - 1);
        //each element is in  (value - min) / gap;
        
        int[] tmpMins = new int[num.length -1];
        Arrays.fill(tmpMins, Integer.MAX_VALUE);
        int[] tmpMaxs = new int[num.length - 1];
        
        for (int i=0; i < num.length; i++)
        {
            if (max == num[i] || min ==num[i])
                continue;
                
            int index = (num[i] - min)/gap;

            tmpMins[index] = Math.min(tmpMins[index], num[i]);
            tmpMaxs[index] = Math.max(tmpMaxs[index], num[i]);
        }
        
        int maxGap = 0;
        int previous = min;
        
        for (int i=0; i < num.length -1; i++)
        {
            if (tmpMins[i] == Integer.MAX_VALUE && tmpMaxs[i] == 0)
                continue;

            maxGap = Math.max(maxGap, tmpMaxs[i] - tmpMins[i]);
            maxGap = Math.max(maxGap, tmpMins[i] - previous);
            previous = tmpMaxs[i];
        }
        
        return Math.max(maxGap, max - previous);
	}
}
