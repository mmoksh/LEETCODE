class Solution {
    public int swimInWater(int[][] grid) {
        boolean[][] visited;
        int X = grid.length, Y = grid[0].length;
        for (int depth = 0; ; depth++) {
            visited = new boolean[X][Y];
            swimInWater(grid, 0, 0, visited, depth);
            if (visited[X - 1][Y - 1]) return depth;
        }
    }

    int[] xAxis = {0, 1, 0, -1};
    int[] yAxis = {1, 0, -1, 0};
    public void swimInWater(int[][] grid, int x, int y, boolean[][] visited, int depth) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length ||
            visited[x][y] || grid[x][y] > depth) {
            return;
        }
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            swimInWater(grid, x + xAxis[i], y + yAxis[i], visited, depth);
        }
    }
}
