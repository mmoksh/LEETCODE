class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int start = 0, i;
        int count = 0, max = 1;
        for (int j = start + 1; j < s.length(); j++) {
            count = j - start + 1;
            for (i = start; i < j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    count = j - i;
                    start = i + 1;
                    break;
                }
            }
            if (count > max) {
                max = count;
            }
        }
        return max;
    }
}
