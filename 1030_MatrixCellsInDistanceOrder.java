class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] result = new int[R * C][2];
        int index = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                result[index][0] = r;
                result[index++][1] = c;
            }
        }
        Arrays.sort(result, (a, b) -> {
            return Math.abs(a[0] - r0) + Math.abs(a[1] - c0)
                    - Math.abs(b[0] - r0) - Math.abs(b[1] - c0);
        });
        return result;
    }
}
