class Solution {
    public static String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replaceAll("[!?',;.]", "").toLowerCase();
        HashSet<String> bannedWords = new HashSet<>();
        bannedWords.addAll(Arrays.asList(banned));
        HashMap<String, Integer> map = new HashMap<>();
        for (String w : paragraph.split(" ")) {
            if (!bannedWords.contains(w))
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        int max = 0;
        String result = null;
        for (Map.Entry<String, Integer> entrySet : map.entrySet()) {
            if (entrySet.getValue() > max) {
                max = entrySet.getValue();
                result = entrySet.getKey();
            }
        }
        return result;
    }
}
