class Solution {
    public static boolean isToeplitzMatrix(int[][] matrix) {
        int x;
        for (int a = 0; a < matrix.length; a++) {
            x = matrix[a][0];
            for (int i = a + 1, j = 1; i < matrix.length && j < matrix[i].length; i++, j++) {
                if (matrix[i][j] != x) return false;
            }
        }
        for (int a = 1; a < matrix[0].length; a++) {
            x = matrix[0][a];
            for (int i = 1, j = a + 1; i < matrix.length && j < matrix[i].length; i++, j++) {
                if (matrix[i][j] != x) return false;
            }
        }
        return true;
    }
}
