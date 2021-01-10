class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ops = 0;
        for (int num: nums) {
            if (map.getOrDefault(k - num, 0) > 0) {
                ops++;
                map.put(k - num, map.get(k - num) - 1);
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return ops;
    }
}
