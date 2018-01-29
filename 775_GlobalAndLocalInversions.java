class Solution {
    public static boolean isIdealPermutation(int[] A) {
        int countL = 0, countG;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                countL++;
            }
        }
        countG = count(A);
        return countG == countL;
    }

    public static int count(int[] A) {
        if (A.length < 2) {
            return 0;
        }
        int m = (A.length + 1) / 2;
        int[] l = Arrays.copyOfRange(A, 0, m);
        int[] r = Arrays.copyOfRange(A, m, A.length);
        return count(l) + count(r) + merge(A, l, r);
    }

    public static int merge(int[] arr, int[] l, int[] r) {
        int i = 0, j = 0, count = 0;
        while (i < l.length || j < r.length) {
            if (i == l.length) {
                arr[i + j] = r[j];
                j++;
            } else if (j == r.length) {
                arr[i + j] = l[i];
                i++;
            } else if (l[i] <= r[j]) {
                arr[i + j] = l[i];
                i++;
            } else {
                arr[i + j] = r[j];
                count += l.length - i;
                j++;
            }
        }
        return count;
    }
}
