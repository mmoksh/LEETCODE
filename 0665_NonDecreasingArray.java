class Solution {
    public boolean checkPossibility(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        
        int tries = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (tries-- == 0) {
                    return false;
                }
                
                if (i == 1 || (nums[i] >= nums[i -2])) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }
            }
        }
        return true;
    }
}
