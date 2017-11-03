class Solution {
    public int[] findErrorNums(int[] nums) {
        boolean [] exists = new boolean[nums.length];
        int duplicated = 0, missing = 0;
        for (int n: nums) {
            if (!exists[n - 1]) {
                exists[n - 1] = true;
            } else {
                duplicated = n;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!exists[i]) {
                missing = i + 1;
                break;
            }
        }
        return new int[] {duplicated, missing};
    }
}
