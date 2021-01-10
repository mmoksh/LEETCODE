class Solution {
    public int totalMoney(int n) {
        int current = 1;
        int week = 1;
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total += current++;
            if (i % 7 == 0) {
                current = ++week;
            }
        }
        return total;
    }
}
