class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // If the start or end cell is an obstacle, return 0
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) {
            return 0;
        }

        // DP array to store the number of unique paths
        int[][] dp = new int[m][n];

        // Initialize the start cell
        dp[0][0] = 1;

        // Fill the DP table
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0; // Obstacle
                } else if (i > 0 || j > 0) {
                    int fromTop = (i > 0) ? dp[i-1][j] : 0;
                    int fromLeft = (j > 0) ? dp[i][j-1] : 0;
                    dp[i][j] = fromTop + fromLeft;
                }
            }
        }

        return dp[m-1][n-1];
    }
}
