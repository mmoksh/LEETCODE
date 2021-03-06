class Solution {
    public static boolean checkPowersOfThree(int n) {
        int[] pows = {1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441, 1594323, 4782969};
        boolean[] taken = new boolean[pows.length];
        HashSet<Integer> visited = new HashSet<>();
        return checkPowersOfThree(n, pows, taken, visited);
    }
    
    public static boolean checkPowersOfThree(int n, int[] pows, boolean[] taken, HashSet<Integer> visited) {
        if (visited.contains(n)) return false;
        visited.add(n);
        if (n == 0) return true;
        for (int i = pows.length - 1; i >= 0; i--) {
            if (pows[i] <= n && !taken[i]) {
                taken[i] = true;
                if (checkPowersOfThree(n - pows[i], pows, taken, visited)) {
                    return true;
                }
                taken[i] = false;
            }
        }
        return false;
    }
}
