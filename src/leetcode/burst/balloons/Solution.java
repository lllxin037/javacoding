
public class Solution {
    
    public int maxCoins(int[] nums) {
        
        int[] values = new int[nums.length+2];
        int n = 1;        
        for (int val : nums)
            if (val > 0) values[n++] = val;
        values[0] = 1;
        values[n] = 1;
        
        int[][] dp = new int[n][n];
        
        for (int k = 2; k < n; k++) {
            
            for (int left = 0; left < n - k; left++) {
                int right = left + k;
                
                for (int i = left + 1; i < right; i++)  {
                    
                    dp[left][right] = Math.max(dp[left][right], 
                    values[i-1] * values[i] * values[i+1] + dp[left][i] + dp[i][right]);
                }
            }
        }
        
        return dp[0][n];
    }
}
