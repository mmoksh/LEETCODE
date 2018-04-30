class Solution {
    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[][] jobs = new int[difficulty.length][2];
        for (int i = 0; i < jobs.length; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }

        Arrays.sort(jobs, (int[] arr1, int[] arr2) -> arr1[0] - arr2[0]);
        int max = jobs[0][1];
        for (int i = 1; i < jobs.length; i++) {
            if (jobs[i][1] < max) {
                jobs[i][1] = max;
            } else {
                max = jobs[i][1];
            }
        }
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int[] job : jobs) {
            treeMap.put(job[0], job[1]);
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
