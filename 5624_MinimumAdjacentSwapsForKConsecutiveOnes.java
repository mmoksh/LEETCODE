class Solution {
    public int minMoves(int[] nums, int k) {
        int[] indices = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                indices[index++] = i;
            }
        }
        int[] left = new int[index];
        for (int i = 1; i < index; i++) {
            left[i] = left[i - 1] + indices[i - 1];
        }
        int[] right = new int[index];
        for (int i = index - 2; i >= 0; i--) {
            right[i] = right[i + 1] + indices[i + 1];
        }
        int leftLength = (k - 1) / 2;
        int rightLength = k / 2;
        int res = Integer.MAX_VALUE;
        for (int i = leftLength; i < index - rightLength; i++) {
            int leftSum = left[i] - (i - leftLength >= 0 ? left[i - leftLength] : 0);
            int rightSum = right[i] - (i + rightLength < index ? right[i + rightLength] : 0);
            int leftCost = indices[i] * leftLength - leftSum - (leftLength + 1) * leftLength / 2;
            int rightCost = rightSum - indices[i] * rightLength - (rightLength + 1) * rightLength / 2;
            int cost = leftCost + rightCost;
            res = Math.min(res, cost);
        }
        return res;
    }
}
