class Solution {
    public String minWindow(String S, String T) {
        int tempEnd;
        String min = "";
        int minSize = 20000000, size;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == T.charAt(0)) {
                tempEnd = findEnd(S, T, i);
                if (tempEnd == -1) {
                    break;
                }
                size = tempEnd - i + 1;
                if (size < minSize) {
                    minSize = size;
                    min = S.substring(i, tempEnd + 1);
                }
            }
        }
        return min;
    }
    
    public int findEnd(String S, String T, int start) {
        int index = 0;
        int i = start;
        for (; i < S.length() && index < T.length(); i++) {
            if (S.charAt(i) == T.charAt(index)) {
                index++;
                if (index == T.length()) {
                    return i;
                }
            }
        }
        return -1;
    }
}
