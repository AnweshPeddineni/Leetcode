class Solution {

    private Integer[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        // memo[i][j] stores LCS(text1[i:], text2[j:])
        memo = new Integer[n1][n2];

        return dfs(text1, text2, 0, 0);
    }

    // Recursive function with memoization
    private int dfs(String s1, String s2, int i, int j) {
        // Base case: if either string is exhausted
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }

        // Return stored result if computed already
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        int result;

        // Case 1: characters match → include them
        if (s1.charAt(i) == s2.charAt(j)) {
            result = 1 + dfs(s1, s2, i + 1, j + 1);
        } else {
            // Case 2: characters do not match → skip one char
            int skipS1 = dfs(s1, s2, i + 1, j);
            int skipS2 = dfs(s1, s2, i, j + 1);
            result = Math.max(skipS1, skipS2);
        }

        memo[i][j] = result;  // store result
        return result;
    }
}

// Time Complexity: O(n1 * n2) There are n1 * n2 states (i, j)

// Each state is computed once due to memoization

// Space Complexity: O(n1 * n2)  // memo table
// + O(n1 + n2)  // recursion call stack in worst case
