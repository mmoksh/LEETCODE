class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int r = 100000000;
        int l = 1;
        int m;
        while (l < r) {
            m = (l + r) / 2;
            if (checkValid(dist, hour, m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return checkValid(dist, hour, r) ? r : -1;
    }
    
    public boolean checkValid(int[] dist, double hour, int speed) {
        double total = 0;
        for (int i = 0; i + 1 < dist.length; i++) {
            total += Math.ceil(dist[i] * 1.0 / speed);
        }
        total += dist[dist.length - 1] * 1.0 / speed;
        return total <= hour;
    }
}
