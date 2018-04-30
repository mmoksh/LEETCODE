class Solution {
    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < difficulty.length; i++) {
            if (treeMap.floorEntry(difficulty[i]) == null || treeMap.floorEntry(difficulty[i]).getValue() < profit[i]) {
                treeMap.put(difficulty[i], profit[i]);
                while (treeMap.ceilingEntry(difficulty[i] + 1) != null && treeMap.ceilingEntry(difficulty[i] + 1).getValue() < profit[i]) {
                    treeMap.remove(treeMap.ceilingKey(difficulty[i] + 1));
                }
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
