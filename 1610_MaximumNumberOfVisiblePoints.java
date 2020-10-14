class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles2 = new ArrayList<>();
        int always_seen = 0;
        for (List<Integer> point: points) {
            int dx = point.get(0) - location.get(0);
            int dy = point.get(1) - location.get(1);
            if (dx == 0 && dy == 0) {
                always_seen++;
            } else {
                angles2.add((Math.toDegrees(Math.atan2(dy, dx)) + 360) % 360);
            }
        }
        Collections.sort(angles2);
        for (int i = 0; i < points.size() - always_seen; i++) {
            angles2.add(angles2.get(i) + 360);
        }
        int j = 0;
        int max = 0;
        for (int i = 0; i < angles2.size() / 2; i++) {
            for (; j < angles2.size(); j++) {
                if (angles2.get(j) - angles2.get(i) > angle) {
                    j--;
                    break;
                }
            }
            if (j == angles2.size()) {
                max = Math.max(max, j - i);
                break;
            }
            max = Math.max(max, j - i + 1);
        }
        return max + always_seen;
    }
}
