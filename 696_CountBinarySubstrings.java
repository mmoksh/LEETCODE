class Solution {
    public static int countBinarySubstrings(String s) {
        int zeros = 0, ones = 0;
        char last = '2', c;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == last) {
                if (c == '0') {
                    if (++zeros > ones) {
                        ones = 0;
                    }
                } else {
                    if (++ones > zeros) {
                        zeros = 0;
                    }
                }
            } else {
                if (c == '0') {
                    zeros = 1;
                } else {
                    ones = 1;
                }
                last = c;
            }
            if (zeros > 0 && ones > 0) {
                count++;
            }
        }
        return count;
    }

}
