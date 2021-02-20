class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int[][] result = new int[isWater.length][isWater[0].length];
        for (int[] res : result) {
            Arrays.fill(res, -1);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[0].length; j++) {
                if (isWater[i][j] == 1) {
                    q.add(i);
                    q.add(j);
                }
            }
        }
        int size;
        int x, y, nextX, nextY;
        int level = 0;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            size = q.size() / 2;
            while (size-- > 0) {
                x = q.poll();
                y = q.poll();
                if (result[x][y] != -1) continue;
                result[x][y] = level;
                for (int d = 0; d < 4; d++) {
                    nextX = x + dx[d];
                    nextY = y + dy[d];
                    if (nextX < 0 || nextY < 0 || nextX == isWater.length
                            || nextY == isWater[0].length
                            || result[nextX][nextY] != -1) {
                        continue;
                    }
                    q.add(nextX);
                    q.add(nextY);
                }
            }
            level++;
        }
        return result;
    }
}
