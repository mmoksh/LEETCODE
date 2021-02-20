class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        int start = 0, next;
        for (int[] group : groups) {
            next = findGroup(group, nums, start);
            if (next == -1) return false;
            start = next + group.length;
        }
        return true;
    }
    public int findGroup(int[] group, int[] nums, int start) {
        int j;
        for (int i = start; i <= nums.length - group.length; i++) {
            for (j = 0; j < group.length; j++) {
                if (group[j] != nums[j + i]) break;
            }
            if (j == group.length) return i;
        }
        return -1;
    }
}
