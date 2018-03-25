class Solution {
    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] v = new int[grid.length],
                h = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                v[j] = Math.max(v[j], grid[i][j]);
                h[i] = Math.max(h[i], grid[i][j]);
            }
        }
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                sum += Math.min(v[j] - grid[i][j], h[i] - grid[i][j]);
            }
        }
        return sum;
    }
}
