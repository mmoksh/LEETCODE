class Solution {
    public static boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        HashSet<Long> visited = new HashSet<>();
        for (int[] is : blocked) {
            visited.add(is[0] * 1000000L + is[1]);
        }
        HashSet<Long> visited2 = (HashSet<Long>) visited.clone();
        return dfs(visited, source[0], source[1], source, target)
                && dfs(visited2, target[0], target[1], target, source);
    }

    private final static int[] MOVES = {0, 1, 0, -1, 0};

    public static boolean dfs(HashSet<Long> visited, int x, int y, int[] source, int[] target) {
        long c = x * 1000000L + y;
        if (x < 0 || y < 0 || x == 1000000 || y == 1000000 || visited.contains(c)) {
            return false;
        }
        visited.add(c);
        if (x == target[0] && y == target[1]) {
            return true;
        }
        if (Math.abs(x - source[0]) + Math.abs(y - source[1]) >= 200) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            if (dfs(visited, x + MOVES[i], y + MOVES[i + 1], source, target)) {
                return true;
            }
        }
        return false;
    }
}
