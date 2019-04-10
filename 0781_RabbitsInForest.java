class Solution {
    public static int numRabbits(int[] answers) {
        int[] arr = new int[1000];

        for (int answer : answers) {
            arr[answer]++;
        }

        int ret = 0;
        for (int i = 0; i < arr.length; i++) {
            ret += Math.ceil(arr[i] * 1.0 / (i + 1)) * (i + 1);
        }
        return ret;
    }
}
