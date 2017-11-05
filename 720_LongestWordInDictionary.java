class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words, new StringComparator());
        HashSet<String> set = new HashSet<>();
        String longestWord = "";
        set.add("");
        for (String word : words) {
            if (set.contains(word.substring(0, word.length() - 1)) || set.contains(word.substring(1))) {
                set.add(word);
                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }
            }
        }
        return longestWord;
    }
}

class StringComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if (o1.length() != o2.length()) return o1.length() - o2.length();
        return o1.compareTo(o2);
    }
}
