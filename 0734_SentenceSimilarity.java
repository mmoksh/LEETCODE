class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        HashMap<String, HashSet<String>> map = new HashMap<>();
        for (String[] pair : pairs) {
            if (map.containsKey(pair[0])) {
                map.get(pair[0]).add(pair[1]);
            } else {
                HashSet<String> hashSet = new HashSet<>();
                hashSet.add(pair[1]);
                map.put(pair[0], hashSet);
            }
            if (map.containsKey(pair[1])) {
                map.get(pair[1]).add(pair[0]);
            } else {
                HashSet<String> hashSet = new HashSet<>();
                hashSet.add(pair[0]);
                map.put(pair[1], hashSet);
            }
        }
        String word1, word2;
        for (int i = 0; i < words1.length; i++) {
            word1 = words1[i];
            word2 = words2[i];
            if (word1.equals(word2) ||
                    map.containsKey(word1) && map.get(word1).contains(word2) ||
                    map.containsKey(word2) && map.get(word2).contains(word1)) {
            } else {
                return false;
            }
        }
        return true;
    }
}
