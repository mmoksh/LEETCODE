class Solution {
    public static int expressiveWords(String S, String[] words) {
        int[][] counts = trimWord(S);
        int count = 0;
        outer:
        for (String word : words) {
            int[][] temp = trimWord(word);
            if (temp.length != counts.length) {
                continue;
            }
            for (int i = 0; i < counts.length; i++) {
                if (counts[i][0] != temp[i][0]) {
                    continue outer;
                }
                if (counts[i][1] < temp[i][1]) {
                    continue outer;
                }
                if (counts[i][1] != temp[i][1] && counts[i][1] < 3) {
                    continue outer;
                }
            }
            count++;
        }
        return count;
    }

    public static int[][] trimWord(String s) {
        int[][] counts = new int[s.length()][2];
        int index = 0;
        counts[0][0] = s.charAt(0);
        counts[0][1] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == counts[index][0]) {
                counts[index][1]++;
            } else {
                counts[++index][0] = s.charAt(i);
                counts[index][1] = 1;
            }
        }
        return Arrays.copyOfRange(counts, 0, index + 1);
    }
}
