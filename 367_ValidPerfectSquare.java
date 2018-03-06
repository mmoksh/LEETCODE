class Solution {
    public static boolean isPerfectSquare(int num) {
        int l = 1, r = 46340, m, mm;
        while (l <= r) {
            m = (l + r) >> 1;
            mm = m * m;
            if (mm == num) {
                return true;
            }
            if (mm > num) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }
}
