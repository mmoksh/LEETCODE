class Solution {
    public int heightChecker(int[] heights) {
        int[] temp = heights.clone();
        Arrays.sort(temp);
        int result = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != heights[i]) {
                result++;
            }
        }
        return result;
    }
}
