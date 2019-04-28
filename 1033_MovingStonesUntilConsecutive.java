class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int [] arr = {a, b, c};
        Arrays.sort(arr);
        a = arr[0];
        b = arr[1];
        c = arr[2];
        int min = 2;
        if (b - a < 2 && c - b < 2) min = 0;
        else if (b - a < 3 || c - b < 3) min = 1;
        return new int[]{min, c - a - 2};
    }
}
