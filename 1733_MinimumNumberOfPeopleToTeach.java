class Solution {
    public static int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        HashSet<Integer>[] sets = new HashSet[languages.length];
        for (int i = 0; i < sets.length; i++) {
            sets[i] = new HashSet<>();
            for (int language : languages[i]) {
                sets[i].add(language);
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            HashSet<Integer> current = new HashSet<>();
            outer:
            for (int[] friendship : friendships) {
                int u = friendship[0];
                int v = friendship[1];
                for (int language : languages[u - 1]) {
                    if (sets[v - 1].contains(language)) {
                        continue outer;
                    }
                }
                if (!sets[v - 1].contains(i)) {
                    current.add(v);
                }
                if (!sets[u - 1].contains(i)) {
                    current.add(u);
                }
            }
            min = Math.min(min, current.size());
        }
        return min;
    }
}
