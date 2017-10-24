class Solution {
    public int myAtoi(String str) {
        int tmpValue = 214748364, d;
        boolean positive = true;
        int n = 0;
        int i;
        for (i = 0; i < str.length(); i++) {
            d = str.charAt(i);
            if ((d >= '0' && d <= '9') || d == '-' || d == '+' || d == ' ') {                
            } else {
                return 0;
            }
            if ((d >= '0' && d <= '9')) {
                break;
            } else if (d == '-') {
                positive = false;
                i++;
                break;
            } else if (d == '+') {
                i++;
                break;
            }
        }
        for (; i < str.length(); i++) {
            d = str.charAt(i);
            if (d < '0' || d > '9') {
                break;
            }
            d -= '0';
            if (n > tmpValue) {
                if (positive) {
                    return 2147483647;
                } else {
                    return -2147483648;
                }
            } else if (n == tmpValue) {
                if (positive && d > 7) {
                    return 2147483647;
                } else if (d > 7) {
                    return -2147483648;
                }
            }
            n = n * 10 + d;
        }
        return positive? n: -n;
    }
}
