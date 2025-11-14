class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();

        if (len1 + len2 != len3) return false;

        // memo[i][j] = -1 (unvisited), 0 (false), 1 (true)
        int[][] memo = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            Arrays.fill(memo[i], -1);
        }

        return dfs(0, 0, s1, s2, s3, memo);
    }

    private boolean dfs(int i, int j, String s1, String s2, String s3, int[][] memo) {
        // If we used all chars from s1 and s2, then we matched s3
        if (i == s1.length() && j == s2.length()) {
            return true;
        }

        // If already computed → return saved result
        if (memo[i][j] != -1) {
            return memo[i][j] == 1;
        }

        int k = i + j; // current index in s3

        boolean canForm = false;

        // Try taking next char from s1
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            if (dfs(i + 1, j, s1, s2, s3, memo)) {
                canForm = true;
            }
        }

        // Try taking next char from s2 (only if not already true)
        if (!canForm && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            if (dfs(i, j + 1, s1, s2, s3, memo)) {
                canForm = true;
            }
        }

        // Store result
        memo[i][j] = canForm ? 1 : 0;
        return canForm;
    }
}


// Time: O(len1 * len2)
// Space: O(len1 * len2) memo table
// + O(len1 + len2) recursion depth  