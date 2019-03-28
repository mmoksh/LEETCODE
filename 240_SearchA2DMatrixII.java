class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (target == matrix[i][j]) return true;
            else if (target < matrix[i][j]) j--;
            else if (target > matrix[i][j]) i++;
        }
        return false;
    }
}
