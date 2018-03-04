class Solution {
    public static int numSubarrayBoundedMax(int[] A, int L, int R) {
        int j;
        int count = 0, max, start;
        for (int i = 0; i < A.length; i++) {
            max = 0;
            start = A.length;
            for (j = i; j < A.length; j++) {
                max = Math.max(max, A[j]);
                if (max > R) {
                    break;
                }
                if (max >= L) {
                    start = Math.min(start, j);
                }
            }
            if (start < A.length) {
                count += j - start;
            }
        }
        return count;
    }
}
