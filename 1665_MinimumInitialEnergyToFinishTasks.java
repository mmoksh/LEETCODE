class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
        int used = 0;
        int current = 0;
        int required;
        for (int[] task: tasks) {
            required = task[1] - current;
            if (required < 0) required = 0;
            current += required;
            used += required;
            current -= task[0];
        }
        return used;
    }
}
