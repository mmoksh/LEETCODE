class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int max_rev = 0;
        for (int i = 1; i < prices.length; i++) {
            max_rev = Math.max(max_rev, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max_rev;
    }
}
