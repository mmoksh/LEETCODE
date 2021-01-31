class Solution {
    public static boolean[] canEat(int[] candiesCount, int[][] queries) {
        long[] totalSum = new long[candiesCount.length];
        for (int i = 1; i < candiesCount.length; i++) {
            totalSum[i] = totalSum[i - 1] + candiesCount[i - 1];
        }
        boolean[] result = new boolean[queries.length];
        for (int q = 0; q < result.length; q++) {
            int type = queries[q][0];
            double day = queries[q][1] + 1;
            double cup = queries[q][2];
            double min = day;
            double max = day * cup;
            double minTarget = totalSum[type] + 1;
            double maxTarget = totalSum[type] + candiesCount[type];
            result[q] = Math.max(min, minTarget) <= Math.min(max, maxTarget);
        }
        return result;
    }
}
