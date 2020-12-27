class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] counts = {0, 0};
        for (int num: students) {
            counts[num]++;
        }
        for (int s: sandwiches) {
            if (counts[s] == 0) {
                return counts[0] + counts[1];
            }
            counts[s]--;
        }
        return 0;
    }
}
