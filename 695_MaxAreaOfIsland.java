class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        boolean [][] visited = new boolean[grid.length][grid[0].length];
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                max = Math.max(max, visit(grid, visited, i, j));
            }
        }
        return max;
    }
    
    public int visit(int[][] grid, boolean[][] visited, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y]) {
            return 0;
        }
        visited[x][y] = true;
        if (grid[x][y] == 0) {
            return 0;
        }
        return 1 + visit(grid, visited, x + 1, y)
             + visit(grid, visited, x, y + 1)
             + visit(grid, visited, x - 1, y)
             + visit(grid, visited, x, y - 1);
    }
}
