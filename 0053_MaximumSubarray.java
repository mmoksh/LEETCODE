class Solution {
    public static int maxSubArray(int[] nums) {
        int maxSum = 0, maxElement = Integer.MIN_VALUE;
        int current = 0;
        for (int num : nums) {
            current += num;
            current = Math.max(current, 0);
            maxSum = Math.max(maxSum, current);
            maxElement = Math.max(maxElement, num);
        }
        if (maxSum == 0) {
            return maxElement;
        } else {
            return maxSum;
        }
    }
}
