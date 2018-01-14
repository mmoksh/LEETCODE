class Solution {
    public static int countPrimeSetBits(int L, int R) {
        boolean[] primes = {false, false, true, true, false, true,
            false, true, false, false, false,
            true, false, true, false, false,
            false, true, false, true, false,
            false, false, true, false, false,
            false, false, false, true, false,
            true, false};
        int counter = 0;
        int s;
        int n;
        for (int i = L; i <= R; i++) {
            n = i;
            s = 0;
            while (n > 0) {
                s += (n & 1);
                n = n >> 1;
            }
            if (primes[s]) {
                counter++;
            }
        }
        return counter;
    }
}
