class Solution {
    public static double champagneTower(int poured, int query_row, int query_glass) {
        double [][] glasses = new double[query_row + 1][query_row + 1];
        glasses[0][0] = poured;
        for (int i = 0; i < query_row; i++) {
            for (int j = 0; j <= i; j++) {
                if (glasses[i][j] > 1) {
                    glasses[i + 1][j] += (glasses[i][j] - 1) / 2;
                    glasses[i + 1][j + 1] += (glasses[i][j] - 1) / 2;
                    glasses[i][j] = 1;
                }
            }
        }
        
        return glasses[query_row][query_glass] > 1? 1: glasses[query_row][query_glass];
    }
}
