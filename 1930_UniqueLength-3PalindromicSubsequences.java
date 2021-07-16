class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] firstIndex = new int[26];
        int[] lastIndex = new int[26];
        boolean[][] palindrom = new boolean[26][26];
        Arrays.fill(firstIndex, -1);
        int output = 0;
        char ch;
        int charIndex;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            charIndex = ch - 'a';
            if (firstIndex[charIndex] == -1) {
                firstIndex[charIndex] = i;
            } else {
                for (int j = 0; j < 26; j++) {
                    if (!palindrom[charIndex][j] && lastIndex[j] > firstIndex[charIndex]) {
                        palindrom[charIndex][j] = true;
                        output++;
                    }
                }
            }
            lastIndex[charIndex] = i;
        }
        return output;
    }
}
