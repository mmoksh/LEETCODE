class Solution {
    

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ret = new LinkedList<>();
        allPathsSourceTarget(graph, new LinkedList<>(), 0, ret);
        return ret;
    }

    public static void allPathsSourceTarget(int[][] graph, List<Integer> tmp, int start, List<List<Integer>> ret) {
        if (start == graph.length - 1) {
            List<Integer> out = new LinkedList<>();
            out.addAll(tmp);
            out.add(start);
            ret.add(out);
            return;
        }
        for (int i : graph[start]) {
            tmp.add(start);
            allPathsSourceTarget(graph, tmp, i, ret);
            tmp.remove(tmp.size() - 1);
        }
    }
}
