class Solution {
    public int minCost(int[][] costs) {
        // Handle edge case where no houses are present
        if (costs == null || costs.length == 0) return 0;
        
        int n = costs.length;
        // Initialize memo with 4 columns to accommodate prevColor = -1, 0, 1, 2
        // prevColor = -1 means there is no previous color
        int[][] dp = new int[n][4];
        for (int[] row : dp) {
            Arrays.fill(row, -1); // Fill with -1 to indicate uncomputed states
        }
        return minCostHelper(costs, 0, -1, dp);
    }

    private int minCostHelper(int[][] costs, int index, int prevColor, int[][] dp) {
        // Base case: all houses have been painted
        if (index == costs.length) {
            return 0;
        }

        // Map prevColor to memoization index
        // -1 -> 0, 0 -> 1, 1 -> 2, 2 -> 3
        int memoColor = prevColor + 1;

        // Check if the result is already computed
        if (dp[index][memoColor] != -1) {
            return dp[index][memoColor];
        }

        int minCost = Integer.MAX_VALUE;

        // Iterate through all possible colors for the current house
        for (int color = 0; color < 3; color++) {
            // Skip the color if it's the same as the previous house's color
            if (color == prevColor) continue;

            // Calculate the cost for painting the current house with the chosen color
            int currentCost = costs[index][color] + minCostHelper(costs, index + 1, color, dp);

            // Update the minimum cost found so far
            minCost = Math.min(minCost, currentCost);
        }

        // Store the computed minimum cost in the memoization array
        dp[index][memoColor] = minCost;
        return minCost;
    }
}
