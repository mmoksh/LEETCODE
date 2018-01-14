class Solution {
    public static int minSwapsCouples(int[] row) {
        int[] indexes = new int[row.length];
        for (int i = 0; i < row.length; i++) {
            indexes[row[i]] = i;
        }
        return minSwapsCouples(row, indexes, 0);
    }

    public static void switchN(int[] row, int[] indexes, int i, int j) {
        int a = row[i];
        int b = row[j];

        row[i] = b;
        row[j] = a;

        indexes[a] = j;
        indexes[b] = i;
    }

    public static int minSwapsCouples(int[] row, int[] indexes, int i) {
        if (i == row.length) {
            return 0;
        }

        int a = row[i];
        int b = a ^ 1;

        if (row[i + 1] == b) {
            return minSwapsCouples(row, indexes, i + 2);
        }

        int b_index = indexes[b];

        switchN(row, indexes, i + 1, b_index);
        return minSwapsCouples(row, indexes, i + 2) + 1;
    }
}
