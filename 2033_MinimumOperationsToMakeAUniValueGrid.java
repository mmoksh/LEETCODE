class Solution {
    public static int minOperations(int[][] grid, int x) {
        int[] hist = new int[10001];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] arr : grid) {
            for (int num : arr) {
                hist[num]++;
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
        }
        for (int i = 1; i < hist.length; i++) {
            if (hist[i] != 0 && (i - min) % x != 0) return -1;
        }
        int[] left = new int[hist.length];
        int[] right = new int[hist.length];
        int count = hist[min];
        for (int i = min + x; i <= max; i += x) {
            left[i] = left[i - x] + count;
            count += hist[i];
        }
        count = hist[max];
        for (int i = max - x; i >= min; i -= x) {
            right[i] = right[i + x] + count;
            count += hist[i];
        }
        int answer = left[min] + right[min];
        for (int i = min + x; i <= max; i += x) {
            answer = Math.min(answer, left[i] + right[i]);
        }
        return answer;
    }
}
