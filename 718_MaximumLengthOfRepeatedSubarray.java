class Solution {
    public int findLength(int[] A, int[] B) {
        int [][] matrix = new int[A.length + 1][B.length + 1];
        int max = 0;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    max = Math.max(max, matrix[i][j]);
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
        return max;
    }
}
