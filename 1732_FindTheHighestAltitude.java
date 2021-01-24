class Solution {
    public int largestAltitude(int[] gain) {
        int sum = 0, max = 0;
        for (int n: gain) {
            sum += n;
            max = Math.max(max, sum);
        }
        return max;
    }
}
