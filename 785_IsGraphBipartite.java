class Solution {
    public static boolean isBipartite(int[][] graph) {
        int[] arr = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (arr[i] != 0) {
                for (int j : graph[i]) {
                    if (arr[j] == arr[i]) {
                        return false;
                    } else {
                        arr[j] = arr[i] ^ 2;
                    }
                }
            } else {
                arr[i] = findClass(arr, graph[i]);
                i--;
            }
        }
        return true;
    }

    public static int findClass(int[] arr, int[] neighbors) {
        for (int neighbor : neighbors) {
            if (arr[neighbor] != 0) {
                return arr[neighbor] ^ 2;
            }
        }
        return 1;
    }
}
