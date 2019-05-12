class Solution {
    public int[] gardenNoAdj(int N, int[][] paths) {
        int[] flowers = new int[N];
        List<Integer>[] G = new LinkedList[N];
        for (int i = 0; i < N; i++) {
            G[i] = new LinkedList<>();
        }
        for (int[] path : paths) {
            int x = path[0] - 1;
            int y = path[1] - 1;
            G[x].add(y);
            G[y].add(x);
        }
        for (int i = 0; i < N; i++) {
            outer:
            for (int flower = 1;; flower++) {
                for (Integer neighbor : G[i]) {
                    if (neighbor < i && flowers[neighbor] == flower) {
                        continue outer;
                    }
                }
                flowers[i] = flower;
                break;
            }
        }
        return flowers;
    }
}
