class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = 0; i + j < s.length(); j++) {
                if (checkPalindrome(s, j, i + j)) {
                    return s.substring(j, i + j + 1);
                }
            }
        }
        return "";
    }
    
    public boolean checkPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }            
        }
        return true;
    }
}
