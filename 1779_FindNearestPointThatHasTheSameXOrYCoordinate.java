class Solution {
    public static int nearestValidPoint(int x, int y, int[][] points) {
        int output = -1;
        int[] point;
        int distance, minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            point = points[i];
            if (point[0] == x)
                distance = Math.abs(y - point[1]);
            else if (point[1] == y)
                distance = Math.abs(x - point[0]);
            else
                continue;
            if (distance < minDistance) {
                minDistance = distance;
                output = i;
            }
        }
        return output;
    }
}
