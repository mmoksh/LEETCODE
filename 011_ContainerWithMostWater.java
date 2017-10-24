class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int tmp;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                tmp = (j - i) * (Math.min(height[i], height[j]));
                if (tmp > max) {
                    max = tmp;
                }
            }
        }
        return max;
    }
}
