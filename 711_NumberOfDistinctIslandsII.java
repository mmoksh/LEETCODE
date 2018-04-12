class Solution {
    public static int numDistinctIslands(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int distinctIslandsCount = 0;
        HashSet<String> islandsHashes = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    ArrayList<int[]> pointsList = new ArrayList<>();
                    discover(grid, i, j, visited, pointsList);
                    int[][] points = new int[pointsList.size()][];
                    pointsList.toArray(points);
                    String temp = getHash(points);
                    if (!islandsHashes.contains(temp)) {
                        islandsHashes.add(temp);
                        hashIslandTransformations(points, islandsHashes);
                        distinctIslandsCount++;
                    }
                }
            }
        }
        return distinctIslandsCount;
    }

    public static void discover(int[][] grid, int x, int y, boolean[][] visited, ArrayList<int[]> list) {
        if (x < 0 || y < 0 || x == grid.length || y == grid[0].length || visited[x][y] || grid[x][y] == 0) {
            return;
        }
        visited[x][y] = true;
        list.add(new int[]{x, y});
        int[] dxs = {0, 0, 1, -1};
        int[] dys = {1, -1, 0, 0};
        for (int i = 0; i < 4; i++) {
            discover(grid, x + dxs[i], y + dys[i], visited, list);
        }
    }

    public static String getHash(int[][] transformation) {
        Arrays.sort(transformation, (int[] a, int[] b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        int[] offsets = getOffsets(transformation);
        for (int[] point : transformation) {
            point[0] -= offsets[0];
            point[1] -= offsets[1];
        }
        StringBuilder hash = new StringBuilder();
        for (int[] point : transformation) {
            hash.append('(').append(point[0]).append(',').append(point[1]).append(')');
        }
        return hash.toString();
    }

    private static int[] getOffsets(int[][] transformation) {
        int[] ret = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        for (int[] point : transformation) {
            ret[0] = Math.min(ret[0], point[0]);
            ret[1] = Math.min(ret[1], point[1]);
        }
        return ret;
    }

    private static void hashIslandTransformations(int[][] points, HashSet<String> islandsHashes) {
        int[][][] allTransformations = new int[7][points.length][];
        int x, y;
        for (int i = 0; i < points.length; i++) {
            x = points[i][0];
            y = points[i][1];
            allTransformations[0][i] = new int[]{-x, y};
            allTransformations[1][i] = new int[]{x, -y};
            allTransformations[2][i] = new int[]{-x, -y};
            allTransformations[3][i] = new int[]{y, x};
            allTransformations[4][i] = new int[]{-y, x};
            allTransformations[5][i] = new int[]{y, -x};
            allTransformations[6][i] = new int[]{-y, -x};
        }

        for (int[][] transformation : allTransformations) {
            islandsHashes.add(getHash(transformation));
        }
    }
}
