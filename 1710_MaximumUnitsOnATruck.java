class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int result = 0;
        int temp;
        for (int[] type: boxTypes) {
            temp = Math.min(truckSize, type[0]);
            truckSize -= temp;
            result += temp * type[1];
            if (truckSize == 0) break;
        }
        return result;
    }
}
