class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[2][m];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        
        for (int i = 1; i < n; i++) {
            dp[1][0] = grid[i][0] + dp[0][0];
            for (int j = 1; j < m; j++) {
                dp[1][j] = Math.min(dp[0][j], dp[1][j - 1]) + grid[i][j];
            }
            dp[0] = dp[1];
        }
        return dp[0][m - 1];
    }
}
