class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int [] max = new int[nums.length];
        Arrays.fill(max, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max[i] = Math.max(max[i], max[j] + 1);
                }
            }
        }
        int m = 1;
        for (int i = 1; i < nums.length; i++) {
            m = Math.max(m, max[i]);
        }
        return m;
    }
}
