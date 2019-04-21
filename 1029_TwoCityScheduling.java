class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> Math.abs(b[0] - b[1]) - Math.abs(a[0] - a[1]));
        int a = 0, b = 0;
        int N = costs.length / 2;
        int total = 0;
        for (int[] cost : costs) {
            if (a < N && b < N) {
                if (cost[0] < cost[1]) {
                    a++;
                    total += cost[0];
                } else {
                    b++;
                    total += cost[1];
                }
            } else if (a < N) {
                a++;
                total += cost[0];
            } else {
                b++;
                total += cost[1];
            }
        }
        return total;
    }
}
