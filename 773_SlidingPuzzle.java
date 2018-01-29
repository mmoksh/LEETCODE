class Solution {
    public static int slidingPuzzle(int[][] board) {
        Queue<int[][]> q = new LinkedList<>();
        HashSet<String> s = new HashSet<>();

        q.add(board);
        s.add(hash(board));
        int d = 0, size;
        String ss;
        int[][] temp;
        
        while (!q.isEmpty()) {
            size = q.size();
            while (size-- > 0) {
                temp = q.poll();
                if (checkSolved(temp)) {
                    return d;
                }
                if (temp[0][0] == 0) {
                    int[][] a = new int[2][3];
                    a[0][0] = temp[0][1];
                    a[0][1] = temp[0][0];
                    a[0][2] = temp[0][2];
                    a[1][0] = temp[1][0];
                    a[1][1] = temp[1][1];
                    a[1][2] = temp[1][2];
                    ss = hash(a);
                    if (!s.contains(ss)) {
                        q.add(a);
                        s.add(ss);
                    }
                    int[][] b = new int[2][3];
                    b[0][0] = temp[1][0];
                    b[0][1] = temp[0][1];
                    b[0][2] = temp[0][2];
                    b[1][0] = temp[0][0];
                    b[1][1] = temp[1][1];
                    b[1][2] = temp[1][2];
                    ss = hash(b);
                    if (!s.contains(ss)) {
                        q.add(b);
                        s.add(ss);
                    }
                } else if (temp[0][1] == 0) {
                    int[][] a = new int[2][3];
                    a[0][0] = temp[0][1];
                    a[0][1] = temp[0][0];
                    a[0][2] = temp[0][2];
                    a[1][0] = temp[1][0];
                    a[1][1] = temp[1][1];
                    a[1][2] = temp[1][2];
                    ss = hash(a);
                    if (!s.contains(ss)) {
                        q.add(a);
                        s.add(ss);
                    }
                    int[][] b = new int[2][3];
                    b[0][0] = temp[0][0];
                    b[0][1] = temp[0][2];
                    b[0][2] = temp[0][1];
                    b[1][0] = temp[1][0];
                    b[1][1] = temp[1][1];
                    b[1][2] = temp[1][2];
                    ss = hash(b);
                    if (!s.contains(ss)) {
                        q.add(b);
                        s.add(ss);
                    }
                    int[][] c = new int[2][3];
                    c[0][0] = temp[0][0];
                    c[0][1] = temp[1][1];
                    c[0][2] = temp[0][2];
                    c[1][0] = temp[1][0];
                    c[1][1] = temp[0][1];
                    c[1][2] = temp[1][2];
                    ss = hash(c);
                    if (!s.contains(ss)) {
                        q.add(c);
                        s.add(ss);
                    }
                } else if (temp[0][2] == 0) {
                    int[][] a = new int[2][3];
                    a[0][0] = temp[0][0];
                    a[0][1] = temp[0][2];
                    a[0][2] = temp[0][1];
                    a[1][0] = temp[1][0];
                    a[1][1] = temp[1][1];
                    a[1][2] = temp[1][2];
                    ss = hash(a);
                    if (!s.contains(ss)) {
                        q.add(a);
                        s.add(ss);
                    }
                    int[][] b = new int[2][3];
                    b[0][0] = temp[0][0];
                    b[0][1] = temp[0][1];
                    b[0][2] = temp[1][2];
                    b[1][0] = temp[1][0];
                    b[1][1] = temp[1][1];
                    b[1][2] = temp[0][2];
                    ss = hash(b);
                    if (!s.contains(ss)) {
                        q.add(b);
                        s.add(ss);
                    }
                } else if (temp[1][0] == 0) {
                    int[][] a = new int[2][3];
                    a[0][0] = temp[1][0];
                    a[0][1] = temp[0][1];
                    a[0][2] = temp[0][2];
                    a[1][0] = temp[0][0];
                    a[1][1] = temp[1][1];
                    a[1][2] = temp[1][2];
                    ss = hash(a);
                    if (!s.contains(ss)) {
                        q.add(a);
                        s.add(ss);
                    }
                    int[][] b = new int[2][3];
                    b[0][0] = temp[0][0];
                    b[0][1] = temp[0][1];
                    b[0][2] = temp[0][2];
                    b[1][0] = temp[1][1];
                    b[1][1] = temp[1][0];
                    b[1][2] = temp[1][2];
                    ss = hash(b);
                    if (!s.contains(ss)) {
                        q.add(b);
                        s.add(ss);
                    }
                } else if (temp[1][1] == 0) {
                    int[][] a = new int[2][3];
                    a[0][0] = temp[0][0];
                    a[0][1] = temp[0][1];
                    a[0][2] = temp[0][2];
                    a[1][0] = temp[1][1];
                    a[1][1] = temp[1][0];
                    a[1][2] = temp[1][2];
                    ss = hash(a);
                    if (!s.contains(ss)) {
                        q.add(a);
                        s.add(ss);
                    }
                    int[][] b = new int[2][3];
                    b[0][0] = temp[0][0];
                    b[0][1] = temp[0][1];
                    b[0][2] = temp[0][2];
                    b[1][0] = temp[1][0];
                    b[1][1] = temp[1][2];
                    b[1][2] = temp[1][1];
                    ss = hash(b);
                    if (!s.contains(ss)) {
                        q.add(b);
                        s.add(ss);
                    }
                    int[][] c = new int[2][3];
                    c[0][0] = temp[0][0];
                    c[0][1] = temp[1][1];
                    c[0][2] = temp[0][2];
                    c[1][0] = temp[1][0];
                    c[1][1] = temp[0][1];
                    c[1][2] = temp[1][2];
                    ss = hash(c);
                    if (!s.contains(ss)) {
                        q.add(c);
                        s.add(ss);
                    }
                } else if (temp[1][2] == 0) {
                    int[][] a = new int[2][3];
                    a[0][0] = temp[0][0];
                    a[0][1] = temp[0][1];
                    a[0][2] = temp[1][2];
                    a[1][0] = temp[1][0];
                    a[1][1] = temp[1][1];
                    a[1][2] = temp[0][2];
                    ss = hash(a);
                    if (!s.contains(ss)) {
                        q.add(a);
                        s.add(ss);
                    }
                    int[][] b = new int[2][3];
                    b[0][0] = temp[0][0];
                    b[0][1] = temp[0][1];
                    b[0][2] = temp[0][2];
                    b[1][0] = temp[1][0];
                    b[1][1] = temp[1][2];
                    b[1][2] = temp[1][1];
                    ss = hash(b);
                    if (!s.contains(ss)) {
                        q.add(b);
                        s.add(ss);
                    }
                }
            }
            d++;
        }

        return -1;
    }

    public static boolean checkSolved(int[][] board) {
        return board[0][0] == 1 && board[0][1] == 2 && board[0][2] == 3
                && board[1][0] == 4 && board[1][1] == 5 && board[1][2] == 0;
    }

    public static String hash(int[][] board) {
        return Arrays.toString(board[0]) + Arrays.toString(board[1]);
    }
}
