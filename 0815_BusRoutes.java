class Solution {
    public static int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) {
            return 0;
        }
        HashMap<Integer, HashSet<Integer>> stopsBuses = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                if (!stopsBuses.containsKey(stop)) {
                    stopsBuses.put(stop, new HashSet<>());
                }
                stopsBuses.get(stop).add(i);
            }
        }
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        visited.add(S);
        q.add(S);
        int size, temp, level = 1;
        while (!q.isEmpty()) {
            size = q.size();
            while (size-- > 0) {
                temp = q.poll();
                for (Integer route : stopsBuses.get(temp)) {
                    for (int stop : routes[route]) {
                        if (!visited.contains(stop)) {
                            if (stop == T) {
                                return level;
                            }
                            visited.add(stop);
                            q.add(stop);
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
