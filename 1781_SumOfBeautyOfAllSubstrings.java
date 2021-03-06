class Solution {
    public static int beautySum(String s) {
        int total = 0;
        int[] hist = new int[26];
        for (int length = 3; length <= s.length(); length++) {
            hist = new int[26];
            for (int j = 0; j < length; j++) {
                hist[s.charAt(j) - 'a']++;
            }
            total += sum(hist);
            for (int j = length; j < s.length(); j++) {
                hist[s.charAt(j) - 'a']++;
                hist[s.charAt(j - length) - 'a']--;
                total += sum(hist);
            }
        }
        return total;
    }
    
    public static int sum(int[] hist) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : hist) {
            if (num == 0) continue;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return max - min;
    }
}
