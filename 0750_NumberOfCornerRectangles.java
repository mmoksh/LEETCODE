class Solution {
    public static int countCornerRectangles(int[][] grid) {
        int count = 0;
        for (int x1 = 0; x1 < grid.length; x1++) {
            for (int x2 = x1 + 1; x2 < grid.length; x2++) {
                for (int j = 0; j < grid[0].length; j++) {
                    count += countCornerRectangles(grid, x1, x2, j);
                }
            }
        }
        return count;
    }
    
    public static int countCornerRectangles(int[][] grid, int x1, int x2, int y) {
        int count = 0;
        if (grid[x1][y] == 1 && grid[x2][y] == 1) {
            for (int j = y + 1; j < grid[0].length; j++) {
                if (grid[x1][j] == 1 && grid[x2][j] == 1)
                    count++;
            }
        }
        return count;
    }
}
