class Solution {
    public String longestNiceSubstring(String s) {
        for (int n = s.length(); n > 0; n--) {
            for (int i = 0; i + n <= s.length(); i++) {
                if (isNice(s, i, i + n)) {
                    return s.substring(i, i + n);
                }
            }
        }
        return "";
    }
    
    public boolean isNice(String s, int a, int b) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        char ch;
        for (int i = a; i < b; i++) {
            ch = s.charAt(i);
            if (Character.isUpperCase(ch)) {
                upper[ch - 'A'] = true;
            } else {
                lower[ch - 'a'] = true;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (lower[i] != upper[i]) return false;
        }
        return true;
    }
}
