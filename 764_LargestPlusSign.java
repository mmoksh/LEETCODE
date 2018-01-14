class Solution {
    public static int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] matrix = new int[N][N];
        for (int[] mine : mines) {
            matrix[mine[0]][mine[1]] = 1;
        }

        int[][] down = new int[N][N];
        for (int j = 0; j < N; j++) {
            down[0][j] = 1 - matrix[0][j];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 1) {
                    down[i][j] = 0;
                } else {
                    down[i][j] += down[i - 1][j] + 1;
                }
            }
        }

        int[][] up = new int[N][N];
        for (int j = 0; j < N; j++) {
            up[N - 1][j] = 1 - matrix[N - 1][j];
        }

        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 1) {
                    up[i][j] = 0;
                } else {
                    up[i][j] += up[i + 1][j] + 1;
                }
            }
        }

        int[][] right = new int[N][N];
        for (int i = 0; i < N; i++) {
            right[i][0] = 1 - matrix[i][0];
        }

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (matrix[i][j] == 1) {
                    right[i][j] = 0;
                } else {
                    right[i][j] += right[i][j - 1] + 1;
                }
            }
        }

        int[][] left = new int[N][N];
        for (int i = 0; i < N; i++) {
            left[i][N - 1] = 1 - matrix[i][N - 1];
        }

        for (int i = 0; i < N; i++) {
            for (int j = N - 2; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    left[i][j] = 0;
                } else {
                    left[i][j] += left[i][j + 1] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(Math.min(Math.min(down[i][j], up[i][j]), Math.min(left[i][j], right[i][j])), max);
            }
        }
        
        return max;
    }
}
