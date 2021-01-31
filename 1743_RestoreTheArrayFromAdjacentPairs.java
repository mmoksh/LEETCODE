class Solution {
    public static int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer, int[]> neighbors = new HashMap<>();
        Integer a, b;
        for (int[] adjacentPair : adjacentPairs) {
            a = adjacentPair[0];
            b = adjacentPair[1];
            if (neighbors.containsKey(a)) {
                neighbors.put(a, new int[]{neighbors.get(a)[0], b});
            } else {
                neighbors.put(a, new int[]{b});
            }
            if (neighbors.containsKey(b)) {
                neighbors.put(b, new int[]{neighbors.get(b)[0], a});
            } else {
                neighbors.put(b, new int[]{a});
            }
        }
        int[] result = new int[adjacentPairs.length + 1];
        for (Map.Entry<Integer, int[]> entry : neighbors.entrySet()) {
            if (entry.getValue().length == 1) {
                result[0] = entry.getKey();
                break;
            }
        }
        for (int i = 1; i < result.length; i++) {
            int[] next = neighbors.get(result[i - 1]);
            if (next.length == 1) {
                result[i] = next[0];
            } else if (next[0] != result[i - 2]) {
                result[i] = next[0];
            } else {
                result[i] = next[1];
            }
        }
        return result;
    }
}
