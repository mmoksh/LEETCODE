class Solution {
    public int waysToSplit(int[] nums) {
        int[] sums = new int[nums.length];
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            sums[i] = total;
        }
        long result = 0;
        int j = 0, k = 0;
        for (int i = 0; i < sums.length - 2; i++) {
            int left = sums[i];
            while (j <= i || j < sums.length - 1 && sums[j] < sums[i] * 2)
                j++;
            while (k < j || k < sums.length - 1 && total - sums[k] >= sums[k] - sums[i])
                k++;
            result = (result + k - j) % 1000000007;
        }
        return (int)result;
    }
}
