class Solution {
    public static boolean checkPartitioning(String s) {
        int N = s.length();
        boolean[][] dp = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < N - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1))
                dp[i][i + 1] = true;
        }
        for (int len = 1; len < N; len++) {
            for (int i = 0; i + len < N; i++) {
                if (s.charAt(i) == s.charAt(i + len) && dp[i + 1][i + len - 1])
                    dp[i][i + len] = true;
            }
        }
        
        for (int i = 0; i < s.length() - 2; i++) {
            if (!dp[0][i]) continue;
            for (int j = i + 1; j < s.length() - 1; j++) {
                if (!dp[j + 1][N - 1] || !dp[i + 1][j]) continue;
                return true;
            }
        }
        return false;
    }
}
