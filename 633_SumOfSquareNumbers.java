class Solution {
    public boolean judgeSquareSum(int c) {
        for (long i = 0; i * i <= c; i++) {
            if (Math.sqrt(c - i * i) % 1 == 0) {
                return true;
            }
        }
        return false;
    }
}
