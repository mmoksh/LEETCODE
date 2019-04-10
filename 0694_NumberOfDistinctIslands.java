class Solution {
    public static int numDistinctIslands(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        HashSet<String> islandsHashes = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    StringBuilder sb = new StringBuilder();
                    discover(grid, i, j, i, j, visited, sb);
                    islandsHashes.add(sb.toString());
                }
            }
        }
        return islandsHashes.size();
    }

    public static void discover(int[][] grid, int x, int y, int xOffset, int yOffset, boolean[][] visited, StringBuilder sb) {
        if (x < 0 || y < 0 || x == grid.length || y == grid[0].length || visited[x][y] || grid[x][y] == 0) {
            return;
        }
        visited[x][y] = true;
        sb.append((x - xOffset) * grid.length * 2 + y - yOffset).append("-");
        int[] dxs = {0, 0, 1, -1};
        int[] dys = {1, -1, 0, 0};
        for (int i = 0; i < 4; i++) {
            discover(grid, x + dxs[i], y + dys[i], xOffset, yOffset, visited, sb);
        }
    }
}
