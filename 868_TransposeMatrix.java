class Solution {
    public static int[][] transpose(int[][] A) {
        int [][] flip = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                flip[j][i] = A[i][j];
            }
        }
        return flip;
    }
}
