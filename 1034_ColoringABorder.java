class Solution {
    private static int[] moves = {0, 1, 0, -1, 0};

    public static int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        dfs(grid, r0, c0, color, grid[r0][c0], visited);
        return grid;
    }
    
    public static int dfs(int[][] grid, int x, int y, int newColor, int oldColor, boolean[][] visited) {
        if (x < 0 || y < 0 || x == grid.length || y == grid[x].length) {
            return 0;
        }
        if (visited[x][y]) {
            return 1;
        }
        if (grid[x][y] != oldColor) {
            return 0;
        }
        visited[x][y] = true;
        int count = 0;
        for (int i = 0; i < 4; i++) {
            count += dfs(grid, x + moves[i], y + moves[i + 1], newColor, oldColor, visited);
        }
        if (count < 4) {
            grid[x][y] = newColor;
        }
        return 1;
    }
}
