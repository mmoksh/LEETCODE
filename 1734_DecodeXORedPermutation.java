class Solution {
    public static int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int target = 0;
        for (int i = 1; i <= n; i++) {
            target ^= i;
        }
        int res = 0;
        for (int i = encoded.length - 1; i > 0; i-=2) {
            res ^= encoded[i];
        }
        int start = target ^ res;
        int[] result = new int[encoded.length + 1];
        result[0] = start;
        for (int i = 1; i < result.length; i++) {
            result[i] = encoded[i - 1] ^ result[i - 1];
        }
        return result;
    }
}
