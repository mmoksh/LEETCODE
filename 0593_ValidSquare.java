class Solution {
    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] arr = {p1, p2, p3, p4};
        Arrays.sort(arr, (int[] a, int[] b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        
        long x = calsDistance2(arr[0], arr[1]);
        long y = calsDistance2(arr[0], arr[3]);
        return x != 0
                && calsDistance2(arr[0], arr[2]) == x
                && calsDistance2(arr[1], arr[3]) == x
                && calsDistance2(arr[2], arr[3]) == x
                && calsDistance2(arr[1], arr[2]) == y;
    }

    public static long calsDistance2(int[] a, int[] b) {
        return (long) (Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
    }
}
