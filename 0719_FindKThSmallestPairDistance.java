class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int [] diffs = new int[1000000];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                diffs[Math.abs(nums[i] - nums[j])]++;
            }
        }
        for (int i = 0; i < diffs.length; i++) {
            if (k <= diffs[i]) {
                return i;
            }
            k -= diffs[i];
        }
        return 0;
    }
}
