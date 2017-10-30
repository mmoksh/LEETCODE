class Solution {
    public boolean hasAlternatingBits(int n) {
        int last = n & 1, b;
        n = n >> 1;
        while (n > 0) {
            b = n & 1;
            if (b == last) {
                return false;
            }
            last = b;
            n = n >> 1;
        }
        return true;
    }
}
