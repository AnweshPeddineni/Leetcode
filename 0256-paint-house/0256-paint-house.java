class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n][3];

        // Base case: For the first house, the minimum cost is the cost of painting it in any color
        for (int i = 0; i < 3; i++) {
            dp[0][i] = costs[0][i];
        }

        // For the remaining houses, calculate the minimum cost based on the previous house's costs
        for (int i = 1; i < n; i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        // The minimum cost of painting all houses is the minimum of the last row in the DP table
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            minCost = Math.min(minCost, dp[n - 1][i]);
        }
        
        return minCost;
    }
}