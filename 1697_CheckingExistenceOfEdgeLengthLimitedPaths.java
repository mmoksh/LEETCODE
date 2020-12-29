class Solution {
    int[] parent;
    int[] rank;
    
    public int getParent(int a) {
        if (parent[a] == a) return a;
        return getParent(parent[a]);
    }
    
    public void join(int a, int b) {
        int pA = getParent(a);
        int pB = getParent(b);
        if (pA == pB) return;
        if (rank[pA] < rank[pB]) {
            parent[pA] = pB;
        } else {
            parent[pB] = pA;
            if (rank[pA] == rank[pB]) {
                rank[pA]++;
            }
        }
    }
    
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        rank = new int[n];
        int[][] q = new int[queries.length][];
        int[] temp;
        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < q.length; i++) {
            temp = queries[i];
            q[i] = new int[]{temp[0], temp[1], temp[2], i};
        }
        Arrays.sort(q, (a, b) -> a[2] - b[2]);
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        int index = 0;
        for (int[] query: q) {
            while (index < edgeList.length && edgeList[index][2] < query[2]) {
                join(edgeList[index][0], edgeList[index][1]);
                index++;
            }
            int pA = getParent(query[0]);
            int pB = getParent(query[1]);
            result[query[3]] = pA == pB;
        }
        return result;
    }
}
