class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int total = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                total += customers[i];
            }
        }
        int windowSum = 0, maxWindowSum;
        for (int i = 0; i < X; i++) {
            if (grumpy[i] == 1) {
                windowSum += customers[i];
            }
        }
        maxWindowSum = windowSum;
        for (int i = X; i < customers.length; i++) {
            if (grumpy[i] == 1) {
                windowSum += customers[i];
            }
            if (grumpy[i - X] == 1) {
                windowSum -= customers[i - X];
            }
            maxWindowSum = Math.max(maxWindowSum, windowSum);
        }
        return maxWindowSum + total;
    }
}
