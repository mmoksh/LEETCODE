class Solution {
    public static String shiftingLetters(String S, int[] shifts) {
        for (int i = shifts.length - 2; i >= 0; i--) {
            shifts[i + 1] %= 26;
            shifts[i] += shifts[i + 1];
        }
        char[] letters = S.toCharArray();
        int c;
        for (int i = 0; i < letters.length; i++) {
            c = (letters[i] - 'a' + shifts[i]) % 26 + 'a';
            letters[i] = (char)c;
        }
        return String.copyValueOf(letters);
    }
}
