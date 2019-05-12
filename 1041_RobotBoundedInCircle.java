class Solution {
    public boolean isRobotBounded(String instructions) {
        int[] xMoves = {1, 0, -1, 0};
        int[] yMoves = {0, 1, 0, -1};
        int x = 0, y = 0, dir = 0;
        char c;
        instructions = instructions + instructions + instructions + instructions;
        for (int i = 0; i < instructions.length(); i++) {
            c = instructions.charAt(i);
            switch (c) {
                case 'G':
                    x += xMoves[dir];
                    y += yMoves[dir];
                    break;
                case 'R':
                    dir = (dir + 1) % 4;
                    break;
                default:
                    dir = (dir + 3) % 4;
                    break;
            }
        }
        return x == 0 && y == 0 && dir == 0;
    }
}
