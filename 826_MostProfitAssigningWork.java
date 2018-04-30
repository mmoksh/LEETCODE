class Solution {
    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < difficulty.length; i++) {
            if (!treeMap.containsKey(difficulty[i]) || treeMap.get(difficulty[i]) < profit[i]) {
                treeMap.put(difficulty[i], profit[i]);
            }
        }
        int max = treeMap.firstEntry().getValue();
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            if (entry.getValue() < max) {
                treeMap.put(entry.getKey(), max);
            } else {
                max = entry.getValue();
            }
        }
        int totalProfit = 0;
        for (int w : worker) {
            Integer i = treeMap.floorKey(w);
            if (i != null) {
                totalProfit += treeMap.get(i);
            }
        }
        return totalProfit;
    }
}
