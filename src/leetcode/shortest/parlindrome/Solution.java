public class Solution {
    
    //http://www.felix021.com/blog/read.php?2040
    
    public String shortestPalindrome(String s) {
        
        if (s == null || s.length() <= 1)
            return s;
            
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder(s).reverse();
        char[] reverseArr = sb.toString().toCharArray();
        
        int maxLen = 0;
        int end = 0;

        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for (int i = 0; i < n; i++) {
            
            for (int j = 0; j < n; j++) {
                
                if (arr[i] != reverseArr[j]) 
                    continue;
                    
                int v = dp[i][j];
                dp[i+1][j+1] = v+1;
                if ( v+1 > maxLen ) {
                    maxLen = v+1;
                    end = j;
                }
            }
        }
        
        //maxlen must >= 1
        
        if (maxLen == 1 ) {
            //no parlindrome at all    
        } else {
            int begin = end - maxLen + 1;
            String parlindrom = sb.substring(begin, end);
        }
        
        return sb.toString();
    }
}
