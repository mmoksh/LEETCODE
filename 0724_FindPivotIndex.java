class Solution {
    public int pivotIndex(int[] nums) {
        int [] rightSum = new int[nums.length];
        int sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            rightSum[i] = sum;
        }
        sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == rightSum[i]) {
                return i;
            }
        }
        return -1;
    }
}
