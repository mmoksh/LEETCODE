class Solution {
    public static double largestTriangleArea(int[][] points) {
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = j + 1; k < points.length; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    max = Math.max(max, calc(points[i], points[j], points[k]));
                }
            }
        }
        return max / 2.0;
    }

    private static int calc(int[] p1, int[] p2, int[] p3) {
        return Math.abs(p1[0] * (p2[1] - p3[1]) + p2[0] * (p3[1] - p1[1]) + p3[0] * (p1[1] - p2[1]));
    }
}
