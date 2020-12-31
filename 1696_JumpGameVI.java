class Solution {
    public int maxResult(int[] nums, int k) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.addFirst(new int[] {nums[0], 0});
        int current;
        for (int i = 1; i < nums.length; i++) {
            current = nums[i] + dq.peekFirst()[0];
            while (!dq.isEmpty() && current >= dq.peekLast()[0]) {
                dq.pollLast();
            }
            dq.addLast(new int[]{current, i});
            if (dq.peekFirst()[1] + k == i) {
                dq.pollFirst();
            }
        }
        return dq.peekLast()[0];
    }
}
