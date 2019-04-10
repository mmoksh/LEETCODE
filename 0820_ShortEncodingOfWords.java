class Solution {
    public static int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, (String a, String b) -> b.length() - a.length());
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (sb.indexOf(word + "#") == -1) {
                sb.append(word).append('#');
            }
        }
        return sb.length();
    }
}
