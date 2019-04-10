class Solution {
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        int sign = 1;
        if (x < 0) {
            sign = -1;
            x = -x;
        }
        int ret = 0;
        while (x > 0) {
            if ((Integer.MAX_VALUE - x % 10) / 10 < ret) {
                return 0;
            }
            ret = ret * 10 + x % 10;
            x /= 10;
        }
        ret *= sign;
        return ret;
    }
}
