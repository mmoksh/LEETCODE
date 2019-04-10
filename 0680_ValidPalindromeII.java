class Solution {
    public boolean validPalindrome(String s) {
        return checkPalindrome(s, 0, s.length() - 1, 1);
    }
    
    public boolean checkPalindrome(String s, int i, int j, int remainTries) {
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++; j--;
            } else if (remainTries > 0) {
                return checkPalindrome(s, i + 1, j, remainTries - 1) || checkPalindrome(s, i, j - 1, remainTries - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
