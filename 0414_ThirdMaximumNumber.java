class Solution {
    public int thirdMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        Integer secondMax = null, thirdMax = null;
        boolean found = true;
        for(int num: nums) {
            if (num > max) {
                max = num;
            }
        }
        for(int num: nums) {
            if (num < max && (secondMax == null || num > secondMax)) {
                secondMax = num;
            }
        }
        if (secondMax == null) {
            return max;
        }
        
        for(int num: nums) {
            if (num < secondMax && (thirdMax == null || num > thirdMax)) {
                thirdMax = num;
            }
        }
        
        return thirdMax == null? max: thirdMax;
    }
}
