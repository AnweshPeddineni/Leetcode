class Solution {
    public String longestPalindrome(String s) {
        
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        
        int start = 0;
        int end = 0;
        
        for(int i = n-1 ; i >= 0; i--){
            for(int j = i+1; j<n; j++){
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j-i <= 2 || dp[i+1][j-1]);
                if(dp[i][j]  && j - i > end - start){
                    start = i;
                    end = j;
                }
            }
        }
        
        return s.substring(start, end+1);
    }
}