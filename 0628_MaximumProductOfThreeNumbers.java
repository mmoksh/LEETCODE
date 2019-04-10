class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int x = nums[0] * nums[1];
        int y = nums[nums.length - 2] * nums[nums.length - 3];
        return Math.max(x, y) * nums[nums.length - 1];
    }
}
