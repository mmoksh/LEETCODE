class Solution {
    public String removeOuterParentheses(String S) {
        int count = 0;
        char[] results = new char[S.length()];
        int index = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                if (++count != 1) results[index++] = '(';
            } else {
                if (--count != 0) results[index++] = ')';
            }
        }
        return String.valueOf(results, 0, index);
    }
}
