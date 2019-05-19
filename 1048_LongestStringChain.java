class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (w1, w2) -> w1.length() - w2.length());
        int[] dp = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (isPredecessor(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        for (int num : dp) {
            max = Math.max(max, num);
        }
        return max;
    }
    
    public boolean isPredecessor(String word1, String word2) {
        if (word1.length() + 1 != word2.length()) return false;
        
        int index = 0;
        for (int i = 0; index < word1.length() && i < word2.length(); i++) {
            if (word1.charAt(index) == word2.charAt(i)) {
                index++;
            }
        }
        return index == word1.length();
    }
}
