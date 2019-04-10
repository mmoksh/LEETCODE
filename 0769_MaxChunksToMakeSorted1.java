class Solution {
    public static int maxChunksToSorted(int[] arr) {
        int chunks = 0;
        int x;
        for (int i = 0; i < arr.length; i++) {
            x = arr[i];
            while (i < x) {
                i++;
                x = Math.max(x, arr[i]);
            }
            chunks++;
        }
        return chunks;
    }
}
