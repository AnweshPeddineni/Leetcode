class Solution {
    public int countSubstrings(String s) {
        int n = s.length(), ans=0;
        
        if(n<=0){
          return 0;
        }
        
        boolean[][] dp = new boolean[n][n];
        
        for(int i=0; i<n; i++){
            dp[i][i] = true;
            ans++;
        }
        
        for(int i=0; i<n-1; i++){
            dp[i][i+1] = (s.charAt(i) == s.charAt(i+1));
            ans += (dp[i][i+1] ? 1 : 0);
        }
        
        // Check for palindromes of length 3 and more
        for (int diff = 2; diff < n; diff++) {
            for (int i = 0; i < n - diff; i++) {
                int j = i + diff;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    ans++;
                }
            }
        }

        return ans;
    }     
    
}
