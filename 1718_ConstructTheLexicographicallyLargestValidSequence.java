class Solution {
    
    public static int[] constructDistancedSequence(int n) {
        int[] output = new int[n * 2 - 1];
        dfs(0, output, new boolean[n + 1]);
        return output;
    }
    
    public static boolean dfs(int index, int [] output, boolean[] visited) {
        if (index == output.length) return true;
        if (output[index] != 0) return dfs(index + 1, output, visited);
        for (int i = visited.length - 1; i > 0; i--) {
            if (visited[i]) continue;
            if (i == 1) {
                visited[1] = true;
                output[index] = 1;
                if (dfs(index + 1, output, visited)) return true;
                visited[1] = false;
                output[index] = 0;
            } else if (index + i < output.length && output[index] == 0 && output[index + i] == 0) {
                visited[i] = true;
                output[index] = i;
                output[index + i] = i;
                if (dfs(index + 1, output, visited)) return true;
                visited[i] = false;
                output[index] = 0;
                output[index + i] = 0;
            }
        }
        return false;
    }

}
