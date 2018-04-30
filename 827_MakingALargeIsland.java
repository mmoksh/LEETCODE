class Solution {
    public static int largestIsland(int[][] grid) {
        int[][] islandIds = new int[grid.length][grid[0].length];
        HashMap<Integer, Integer> islandsSizes = new HashMap<>();
        int islandId = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int count = markIslands(grid, i, j, islandId, islandIds);
                if (count > 0) {
                    islandsSizes.put(islandId, count);
                    islandId++;
                }
            }
        }

        int maxSize = 0;
        islandsSizes.put(0, 0);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    HashSet<Integer> hashSet = new HashSet<>();
                    if (i > 0) {
                        hashSet.add(islandIds[i - 1][j]);
                    }
                    if (i < grid.length - 1) {
                        hashSet.add(islandIds[i + 1][j]);
                    }
                    if (j > 0) {
                        hashSet.add(islandIds[i][j - 1]);
                    }
                    if (j < grid[0].length - 1) {
                        hashSet.add(islandIds[i][j + 1]);
                    }
                    int sum = 0;
                    for (Integer integer : hashSet) {
                        sum += islandsSizes.get(integer);
                    }
                    if (sum > maxSize) {
                        maxSize = sum;
                    }
                }
            }
        }
        if (islandsSizes.containsKey(1) && islandsSizes.get(1) == grid.length * grid[0].length) {
            return grid.length * grid[0].length;
        } else {
            return maxSize + 1;
        }
    }

    public static int markIslands(int[][] grid, int x, int y, int islandId, int[][] islandIds) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0 || islandIds[x][y] > 0) {
            return 0;
        }
        int result = 1;
        islandIds[x][y] = islandId;
        int[] Xs = {0, 1, 0, -1};
        int[] Ys = {1, 0, -1, 0};
        for (int i = 0; i < 4; i++) {
            result += markIslands(grid, x + Xs[i], y + Ys[i], islandId, islandIds);
        }
        return result;
    }
}
