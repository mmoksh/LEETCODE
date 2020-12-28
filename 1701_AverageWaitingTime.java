class Solution {
    public double averageWaitingTime(int[][] customers) {
        int end = 0;
        double total = 0;
        for (int[] customer: customers) {
            end = Math.max(end, customer[0]) + customer[1];
            total += end - customer[0];
        }
        return total / customers.length;
    }
}
