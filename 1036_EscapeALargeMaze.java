class Solution {
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        return isEscapePossible2(blocked, source, target) && isEscapePossible2(blocked, target, source);
    }
    
    public boolean isEscapePossible2(int[][] blocked, int[] source, int[] target) {
        HashSet<Long> visited = new HashSet<>();
        for (int[] is : blocked) {
            visited.add(is[0] * 1000000L + is[1]);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(source[0]);
        q.add(source[1]);
        visited.add(source[0] * 1000000L + source[1]);
        int steps = 0;
        int x, y, a, b;
        long c;
        int [] d = {1, 0, -1, 0, 1};
        int size;
        while (!q.isEmpty()) {
            size = q.size() / 2;
            steps++;
            if (steps > 200) return true;
            while (size > 0) {
                size -= 2;
                x = q.poll();
                y = q.poll();
                for (int i = 0; i < 4; i++) {
                    a = x + d[i];
                    b = y + d[i + 1];
                    if (a == target[0] && b == target[1]) return true;
                    if (a < 0 || b < 0 || a >= 1000000 || b >= 1000000) continue;
                    c = a * 1000000L + b;
                    if (!visited.contains(c)) {
                        visited.add(c);
                        q.add(a);
                        q.add(b);
                    }
                }
            }
        }
        return false;
    }
}
