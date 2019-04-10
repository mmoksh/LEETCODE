class Solution {
    public static int[] numberOfLines(int[] widths, String S) {
        int counter = 0;
        char c;
        int linesCount = 0;
        for (int i = 0; i < S.length(); i++) {
            c = S.charAt(i);
            if (counter + widths[c - 'a'] > 100) {
                i--;
                counter = 0;
                linesCount++;
            } else {
                counter += widths[c - 'a'];
            }
        }
        return S.length() > 0 ? new int[]{linesCount + 1, counter} : new int[]{0, 0};
    }
}
