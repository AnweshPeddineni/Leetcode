class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return "";

        boolean[][] dp = new boolean[n][n];
        int[] ans = {0, 0};

        // Initialize single character substrings as palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Iterate over all possible lengths of substrings
        for (int diff = 1; diff < n; diff++) {
            for (int i = 0; i < n - diff; i++) {
                int j = i + diff;

                if (s.charAt(i) == s.charAt(j)) {
                    if (diff == 1 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        ans[0] = i;
                        ans[1] = j;
                    }
                }
            }
        }

        int i = ans[0];
        int j = ans[1];
        return s.substring(i, j + 1);
    }
}