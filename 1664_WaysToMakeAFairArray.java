class Solution {
    public int waysToMakeFair(int[] nums) {
        int[] even = new int[nums.length + 1];
        int[] odd = new int[nums.length + 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            even[i] += even[i + 1];
            odd[i] += odd[i + 1];
            if (i % 2 == 0) {
                odd[i] += nums[i];
            } else {
                even[i] += nums[i];
            }
        }
        int x, y;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            x = odd[0] - odd[i] + even[i + 1];
            y = even[0] - even[i] + odd[i + 1];
            if (x == y) result++;
        }
        return result;
    }
}
