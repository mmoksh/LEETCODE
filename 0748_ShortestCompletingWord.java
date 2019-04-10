class Solution {
    public static String shortestCompletingWord(String licensePlate, String[] words) {
        licensePlate = licensePlate.toLowerCase();
        int[] letters = new int[26];
        char c;
        for (int i = 0; i < licensePlate.length(); i++) {
            c = (char) (licensePlate.charAt(i) - 'a');
            if (c >= 0 && c <= 26) {
                letters[c]++;
            }
        }

        int min = Integer.MAX_VALUE;
        String ret = "";

        int[] temp;
        int i;
        for (String word : words) {
            if (word.length() >= min) {
                continue;
            }
            temp = hist(word);
            for (i = 0; i < 26; i++) {
                if (temp[i] < letters[i]) {
                    break;
                }
            }
            if (i == 26) {
                min = word.length();
                ret = word;
            }
        }
        return ret;
    }

    public static int[] hist(String word) {
        int[] letters = new int[26];
        char c;
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            c = (char) (word.charAt(i) - 'a');
            if (c >= 0 && c <= 26) {
                letters[c]++;
            }
        }
        return letters;
    }
}
