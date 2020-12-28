class Solution {
    public int[] findBall(int[][] grid) {
        int current, next;
        int[] output = new int[grid[0].length];
        Arrays.fill(output, -1);
        outer:
        for (int c = 0; c < grid[0].length; c++) {
            current = c;
            for (int r = 0; r < grid.length; r++) {
                next = current + grid[r][current];
                if (next < 0 || next >= grid[0].length || grid[r][current] != grid[r][next]) {
                    output[c] = -1;
                    continue outer;
                }
                current = next;
            }
            output[c] = current;
        }
        return output;
    }
}
