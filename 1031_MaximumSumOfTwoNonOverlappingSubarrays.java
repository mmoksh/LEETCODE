class Solution {
    public static int maxSumTwoNoOverlap(int[] A, int L, int M) {
        return Math.max(maxSumTwoNoOverlap2(A, L, M), maxSumTwoNoOverlap2(A, M, L));
    }

    public static int maxSumTwoNoOverlap2(int[] A, int L, int M) {
        int LSum = 0;
        int max = 0;
        for (int i = 0; i < L - 1; i++) {
            LSum += A[i];
        }
        max = 0;
        int prevL = 0;
        for (int i = L - 1; i < A.length - M; i++) {
            LSum += A[i] - prevL;
            prevL = A[i - L + 1];
            max = Math.max(max, LSum + bestM(A, i + 1, M));
        }
        return max;
    }

    public static int bestM(int[] A, int start, int M) {
        int sumM = 0;
        int prev = 0;
        int max = 0;
        for (int i = start; i < start + M - 1; i++) {
            sumM += A[i];
        }
        for (int i = start + M - 1; i < A.length; i++) {
            sumM += A[i] - prev;
            prev = A[i - M + 1];
            max = Math.max(sumM, max);
        }
        return max;
    }
}
