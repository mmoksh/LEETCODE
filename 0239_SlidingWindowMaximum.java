class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<int[]> dq = new ArrayDeque<>();
        for (int i = 0; i < k - 1; i++) {
            while (!dq.isEmpty() && nums[i] >= dq.peekLast()[0]) {
                dq.pollLast();
            }
            dq.addLast(new int[]{nums[i], i});
        }
        int[] res = new int[nums.length - k + 1];
        for (int i = k - 1; i < nums.length; i++) {
            while (!dq.isEmpty() && nums[i] >= dq.peekLast()[0]) {
                dq.pollLast();
            }
            dq.addLast(new int[]{nums[i], i});
            res[i - k + 1] = dq.peekFirst()[0];
            if (dq.peekFirst()[1] + k - 1 == i) {
                dq.pollFirst();
            }
        }
        return res;
    }
}
