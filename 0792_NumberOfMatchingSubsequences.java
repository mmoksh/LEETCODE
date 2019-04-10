class Solution {
    public static int numMatchingSubseq(String S, String[] words) {
        int count = 0;
        for (String word : words) {
            if (isSubs(word, S)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isSubs(String word, String S) {
        int start = 0, x;
        for (int i = 0; i < word.length(); i++) {
            x = S.indexOf(word.charAt(i), start);
            if (x < 0) {
                return false;
            }
            start = x + 1;
        }
        return true;
    }
}
