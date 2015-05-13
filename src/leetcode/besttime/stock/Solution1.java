package leetcode.besttime.stock;

public class Solution1 {
    
    public int maxProfit(int[] prices) {
        
        if (prices == null || prices.length < 2)
            return 0;
        
        int maxProfit = 0;
        int minIndex = 0;
        for(int i = 1; i < prices.length; i++ ) {
            
            if (prices[i] < prices[minIndex] ) {
                minIndex = i;
            }
            
            maxProfit = Math.max(maxProfit, prices[i] - prices[minIndex]);
        }
        
        return maxProfit;
    }
}