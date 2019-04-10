class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i, count, maxCount = 0;
        for (i = 1; i < nums.length; i++) {
            count = 0;
            while (i < nums.length && nums[i] > nums[i - 1]) {
                count++;
                i++;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount + 1;
    }
}
