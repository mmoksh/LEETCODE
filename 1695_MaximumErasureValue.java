class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int[] sums = new int[nums.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        int num;
        int max = 0;
        int start = -1;
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            num = nums[i];
            curr += num;
            sums[i] = curr;
            if (map.containsKey(num)) {
                start = Math.max(start, map.get(num));
            }
            max = Math.max(max, sums[i] - (start >= 0 ? sums[start] : 0));
            map.put(num, i);
        }
        return max;
    }
}
