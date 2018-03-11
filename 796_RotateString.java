class Solution {
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) return false;
        int length = A.length();
        outer:
        for (int bStart = 0; bStart < A.length(); bStart++) {
            for (int i = 0; i < length; i++) {
                if (A.charAt(i) != B.charAt((i + bStart) % length))
                    continue outer;
            }
            return true;
        }
        return false;
    }
}
