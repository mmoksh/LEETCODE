class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        int a, b;
        while (i < j) {
            a = s.charAt(i);
            if (a >= 'A' && a <= 'Z') {
                a = a - 'A' + 'a';
            } else if (a >= '0' && a <= '9') {
                
            } else if (a < 'a' || a > 'z') {
                i++;
                continue;
            }
            b = s.charAt(j);
            if (b >= 'A' && b <= 'Z') {
                b = b - 'A' + 'a';
            } else if (b >= '0' && b <= '9') {
                
            } else if (b < 'a' || b > 'z') {
                j--;
                continue;
            }
            if (a != b) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
