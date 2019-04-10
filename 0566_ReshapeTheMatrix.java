class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length * nums[0].length != r * c) return nums;
        int index = 0, x, y;
        int [][] ret = new int[r][c];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                x = index / c;
                y = index % c;
                index++;
                ret[x][y] = nums[i][j];
            }
        }
        return ret;
    }
}
