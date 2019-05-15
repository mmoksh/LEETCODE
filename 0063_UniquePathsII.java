class Solution {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[2][n];
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            dp[1][0] = obstacleGrid[i][0] == 1 ? 0 : dp[0][0];
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[1][j] = 0;
                } else {
                    dp[1][j] = dp[1][j - 1] + dp[0][j];
                }
            }
            dp[0] = dp[1];
        }

        return dp[0][n - 1];
    }
}
