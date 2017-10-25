class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        long mult = 1;
        long count = 0;
        int low = 0;
        for (int i = 0; i < nums.length; i++) {
            mult *= nums[i];
            while (mult >= k && low < nums.length) {
                mult /= nums[low++];
            }
            if (low > i) {
                continue;
            }
            int x = i - low;
            long duplicate = (x % 1 == 0)? x / 2 * (x + 1): (x + 1) / 2 * x;
            long new_subs = (x % 1 == 1)? (x + 1) / 2 * (x + 2): (x + 2) / 2 * (x + 1);
            count -= duplicate;
            count += new_subs;
        }
        return (int)count;
    }
}
