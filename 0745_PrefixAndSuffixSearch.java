class WordFilter {
    HashMap<String, Integer> map;
    
    public WordFilter(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                for (int k = 0; k <= words[i].length(); k++) {
                    map.put(words[i].substring(0, j) + "#" + words[i].substring(k), i);
                }
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        return map.getOrDefault(prefix + "#" + suffix, -1);
    }
}
