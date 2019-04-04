class Solution {
    public int numEnclaves(int[][] A) {
        int result = 0;
        boolean [][] visited = new boolean[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            numEnclaves(A, visited, i, 0);
            numEnclaves(A, visited, i, A[0].length - 1);
        }
        
        for (int j = 0; j < A[0].length; j++) {
            numEnclaves(A, visited, 0, j);
            numEnclaves(A, visited, A.length - 1, j);
        }
        
        for (int i = 1; i + 1 < A.length; i++) {
            for (int j = 1; j + 1 < A[0].length; j++) {
                if (!visited[i][j] && A[i][j] == 1) {
                    result++;
                }
            }
        }
        return result;
    }
    
    int [] xMoves = {1, 0, -1, 0};
    int [] yMoves = {0, 1, 0, -1};

    public int numEnclaves(int[][] A, boolean[][] visited, int x, int y) {
        if (x < 0 || y < 0 || x == A.length || y == A[0].length || 
                visited[x][y] || A[x][y] == 0) {
            return 0;
        }

        visited[x][y] = true;
        int result = 1;
        for (int i = 0; i < xMoves.length; i++) {
            result += numEnclaves(A, visited, x + xMoves[i], y + yMoves[i]);
        }
        
        return result;
    }
}
