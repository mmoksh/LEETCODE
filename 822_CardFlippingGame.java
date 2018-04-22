class Solution {
    public static int flipgame(int[] fronts, int[] backs) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                set.add(fronts[i]);
            }
        }
        int min = 100000;
        for (int num : fronts) {
            if (!set.contains(num)) {
                min = Math.min(min, num);
            }
        }
        
        for (int num : backs) {
            if (!set.contains(num)) {
                min = Math.min(min, num);
            }
        }
        return min == 100000? 0: min;
    }
}
