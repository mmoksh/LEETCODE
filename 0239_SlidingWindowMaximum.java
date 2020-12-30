class Solution {
    public void addToMaxQueue(Deque<int[]> dq, int num, int index) {
        while (!dq.isEmpty() && num >= dq.peekLast()[0]) {
            dq.pollLast();
        }
        dq.addLast(new int[]{num, index});
    }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<int[]> dq = new ArrayDeque<>();
        for (int i = 0; i < k - 1; i++) {
            addToMaxQueue(dq, nums[i], i);
        }
        int[] res = new int[nums.length - k + 1];
        for (int i = k - 1; i < nums.length; i++) {
            addToMaxQueue(dq, nums[i], i);
            res[i - k + 1] = dq.peekFirst()[0];
            if (dq.peekFirst()[1] + k - 1 == i) {
                dq.pollFirst();
            }
        }
        return res;
    }
}
