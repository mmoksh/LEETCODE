class Solution {
    public static int preimageSizeFZF(int K) {
        long l = 0, r = 5000000000L, m, sum, temp;
        while (l <= r) {
            m = (l + r) >> 1;
            temp = m;
            sum = 0;
            while (temp > 0) {
                temp /= 5;
                sum += temp;
            }
            if (sum == K) {
                return 5;
            }
            if (sum > K) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return 0;
    }
}
