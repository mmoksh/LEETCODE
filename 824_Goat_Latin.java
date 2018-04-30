class Solution {
    public static String toGoatLatin(String S) {
        String[] words = S.split(" ");
        StringBuilder result = new StringBuilder();
        StringBuilder suffex = new StringBuilder("a");
        for (String word : words) {
            switch (Character.toLowerCase(word.charAt(0))) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    word += "ma";
                    break;
                default:
                    char ch = word.charAt(0);
                    word = word.substring(1) + ch + "ma";
            }
            result.append(word).append(suffex).append(' ');
            suffex.append('a');
        }
        return result.toString().trim();
    }
}
