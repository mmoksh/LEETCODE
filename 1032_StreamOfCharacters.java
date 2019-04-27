class StreamChecker {

    private final static class Trie {

        String word;
        Trie[] children;

        public Trie() {
            word = null;
            children = new Trie[26];
        }
    }

    Trie root;
    int[] queries;
    int queriesCount;

    public void addWordToTrie(String word) {
        Trie temp = root;
        int c;
        for (int i = word.length() - 1; i >= 0; i--) {
            c = word.charAt(i) - 'a';
            if (temp.children[c] == null) {
                temp.children[c] = new Trie();
            }
            temp = temp.children[c];
        }
        temp.word = word;
    }

    public StreamChecker(String[] words) {
        root = new Trie();
        queries = new int[40000];
        queriesCount = 0;
        for (String word : words) {
            addWordToTrie(word);
        }
    }

    public boolean query(char letter) {
        queries[queriesCount++] = letter - 'a';
        Trie temp = root;
        int c;
        for (int i = queriesCount - 1; i >= 0; i--) {
            c = queries[i];
            if (temp.children[c] == null) {
                return false;
            }
            temp = temp.children[c];
            if (temp.word != null) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
