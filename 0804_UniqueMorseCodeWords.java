class Solution {
    public static int uniqueMorseRepresentations(String[] words) {
        String [] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> hash = new HashSet<>();
        StringBuilder sb;
        for (String word : words) {
            sb = new StringBuilder(word.length() * 3);
            for (int i = 0; i < word.length(); i++) {
                sb.append(codes[word.charAt(i) - 'a']);
            }
            hash.add(sb.toString());
        }
        return hash.size();
    }
}
