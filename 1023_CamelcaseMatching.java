class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<>(queries.length);
        for (String query : queries) {
            result.add(match(query, pattern));
        }
        return result;
    }
    
    public boolean match(String word, String pattern) {
        int i, j = 0;
        for (i = 0; i < word.length(); i++) {
            if (j < pattern.length() && word.charAt(i) == pattern.charAt(j)) {
                j++;
            } else if (word.charAt(i) > 'z' || word.charAt(i) < 'a') {
                return false;
            }
        }
        return i == word.length() && j == pattern.length();
    }
}
