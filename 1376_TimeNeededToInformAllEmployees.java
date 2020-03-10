class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<Integer>[] subordinates = new ArrayList[manager.length];
        for (int i = 0; i < subordinates.length; i++) {
            subordinates[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < manager.length; i++) {
            if (i == headID) continue;
            subordinates[manager[i]].add(i);
        }
        return dfs(subordinates, headID, informTime);
    }
    
    public int dfs(ArrayList<Integer>[] subordinates, int p, int[] informTime) {
        if (subordinates[p].size() == 0) {
            return 0;
        }
        int max = 0;
        for (int i: subordinates[p]) {
            max = Math.max(dfs(subordinates, i, informTime), max);
        }
        return max + informTime[p];
    }
}
