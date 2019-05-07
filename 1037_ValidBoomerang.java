class Solution {
    public static boolean isBoomerang(int[][] points) {
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (Arrays.equals(points[i], points[j])) {
                    return false;
                }
            }
        }

        return !onSameLine(
                points[0][0], points[0][1],
                points[1][0], points[1][1],
                points[2][0], points[2][1]);
    }

    public static boolean onSameLine(int x1, int y1, int x2, int y2, int x3, int y3) {
        return (y3 - y1) * (x2 - x1) == (x3 - x1) * (y2 - y1);
    }
}
