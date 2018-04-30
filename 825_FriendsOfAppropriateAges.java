class Solution {
    public static int numFriendRequests(int[] ages) {
        int[] histogram = new int[121];
        for (int age : ages) {
            histogram[age]++;
        }

        int result = 0;
        for (int i = 1; i < histogram.length; i++) {
            if (histogram[i] > 0) {
                for (int j = i - 1; j > 0 && (j - 7) * 2 > i; j--) {
                    result += histogram[i] * histogram[j];
                }
                if (i > 14) {
                    result += histogram[i] * (histogram[i] - 1);
                }
            }
        }
        return result;
    }
}
