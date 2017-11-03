class Solution {
    public int[][] imageSmoother(int[][] M) {
        int [][] ret = new int[M.length][M[0].length];
        for (int i = 0; i < ret.length; i++) {
            for (int j = 0; j < ret[i].length; j++) {
                ret[i][j] = calc(M, i, j);
            }
        }
        return ret;
    }
    
    public int calc(int[][] M, int x, int y) {
        int count = 0, sum = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            if (i < 0 || i >= M.length) {
                continue;
            }
            for (int j = y - 1; j <= y + 1; j++) {
                if (j < 0 || j >= M[i].length) {
                    continue;
                }
                count++;
                sum += M[i][j];
            }
        }
        return sum / count;
    }
}
