class Solution {
    public int videoStitching(int[][] clips, int T) {
        boolean[] taken = new boolean[clips.length];
        int start = 0;
        int count = 0;
        int index;
        while (start < T) {
            index = videoStitching(clips, taken, start);
            if (index == -1) return -1;
            taken[index] = true;
            start = clips[index][1];
            count++;
        }
        return count;
    }
    
    public int videoStitching(int[][] clips, boolean [] taken, int start) {
        int max = -1;
        int index = -1;
        for (int i = 0; i < clips.length; i++) {
            if (taken[i]) {
                continue;
            }
            if (clips[i][0] <= start && clips[i][1] > max) {
                max = clips[i][1];
                index = i;
            }
        }
        return index;
    }
}
