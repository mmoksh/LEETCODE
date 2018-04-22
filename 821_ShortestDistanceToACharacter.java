class Solution {
    public static int[] shortestToChar(String S, char C) {
        int[] forwards = new int[S.length()];
        int[] backwards = new int[S.length()];
        
        int last = -1000000;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                forwards[i] = i;
                last = i;
            } else {
                forwards[i] = last;
            }
        }
        
        last = 100000000;
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) == C) {
                backwards[i] = i;
                last = i;
            } else {
                backwards[i] = last;
            }
        }
        int[] ret = new int[S.length()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = Math.min(i - forwards[i], backwards[i] - i);
        }
        return ret;
    }
}
