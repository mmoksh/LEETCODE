class Solution {
    public static int rotatedDigits(int N) {
        int ret = 0, temp, d, v;
        outer:
        for (int i = 1; i <= N; i++) {
            temp = i;
            v = 0;
            while (temp > 0) {
                d = temp % 10;
                temp /= 10;
                switch (d) {
                    case 2:
                    case 5:
                    case 6:
                    case 9:
                        v = 1;
                        break;
                    case 0:
                    case 1:
                    case 8:
                        break;
                    default:
                        continue outer;
                }
            }
            ret += v;
        }
        return ret;
    }
}
