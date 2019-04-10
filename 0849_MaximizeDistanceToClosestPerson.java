class Solution {
    public static int maxDistToClosest(int[] seats) {
        int count = 0;
        int i;
        for (i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                break;
            }
            count++;
        }
        int max = count;
        for (i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                count++;
            } else {
                max = Math.max((count + 1) / 2, max);
                count = 0;
            }
        }
        count = 0;
        for (i = seats.length - 1; i >= 0; i--) {
            if (seats[i] == 1) {
                break;
            }
            count++;
        }
        return Math.max(max, count);
    }
}
