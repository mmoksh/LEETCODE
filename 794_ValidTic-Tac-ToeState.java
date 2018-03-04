class Solution {
    public static boolean validTicTacToe(String[] board) {
        int count = count(board);
        if (count != 0 && count != 1) {
            return false;
        }
        int winsX = wins(board, 'X');
        int winsO = wins(board, 'O');
        if (winsX > 0 && winsO > 0) {
            return false;
        }
        if (winsX > 1 || winsO > 1) {
            return false;
        }
        if (winsX == 1 && count != 1) {
            return false;
        }
        if (winsO == 1 && count != 0) {
            return false;
        }
        return true;
    }

    public static int count(String[] board) {
        int count = 0;
        for (String string : board) {
            for (int i = 0; i < 3; i++) {
                if (string.charAt(i) == 'X') {
                    count++;
                } else if (string.charAt(i) == 'O') {
                    count--;
                }
            }
        }
        return count;
    }

    private static int wins(String[] board, char c) {
        int count = 0;
        if (board[0].charAt(0) == c && board[0].charAt(1) == c && board[0].charAt(2) == c) {
            count++;
        }
        if (board[1].charAt(0) == c && board[1].charAt(1) == c && board[1].charAt(2) == c) {
            count++;
        }
        if (board[2].charAt(0) == c && board[2].charAt(1) == c && board[2].charAt(2) == c) {
            count++;
        }
        if (board[0].charAt(0) == c && board[1].charAt(0) == c && board[2].charAt(0) == c) {
            count++;
        }
        if (board[0].charAt(1) == c && board[1].charAt(1) == c && board[2].charAt(1) == c) {
            count++;
        }
        if (board[0].charAt(2) == c && board[1].charAt(2) == c && board[2].charAt(2) == c) {
            count++;
        }
        if (board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c) {
            count++;
        }
        if (board[0].charAt(2) == c && board[1].charAt(1) == c && board[2].charAt(0) == c) {
            count++;
        }
        return count;
    }
}
