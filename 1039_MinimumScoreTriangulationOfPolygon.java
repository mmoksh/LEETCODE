class Solution {
    static int[][] memo;
    static int N;
    static int[] A;

    public static int minScoreTriangulation(int[] _A) {
        A = _A;
        N = A.length;
        memo = new int[N][N];
        for (int[] is : memo) {
            Arrays.fill(is, -1);
        }
        int min = Integer.MAX_VALUE, temp;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    temp = A[i] * A[j] * A[k]
                            + solve(i, j)
                            + solve(j, k)
                            + solve(k, i);
                    min = Math.min(min, temp);
                }
            }
        }
        return min;
    }

    public static int solve(int start, int end) {
        if (start == end || next(start) == end || prev(start) == end) {
            return 0;
        }
        if (memo[start][end] != -1) {
            return memo[start][end];
        }
        int min = Integer.MAX_VALUE, temp;
        for (int i = next(start); i != end; i = next(i)) {
            temp = A[start] * A[i] * A[end] + solve(start, i) + solve(i, end);
            min = Math.min(min, temp);
        }
        memo[start][end] = min;
        return min;
    }

    public static int next(int i) {
        return (i + 1) % N;
    }

    public static int prev(int i) {
        return (i - 1 + N) % N;
    }
}
