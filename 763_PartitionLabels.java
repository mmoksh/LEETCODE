class Solution {
    public static List<Integer> partitionLabels(String S) {
        List<Integer> ret = new ArrayList<>();
        char c;
        int lastIndex;
        for (int i = 0; i < S.length(); i++) {
            c = S.charAt(i);
            lastIndex = S.lastIndexOf(c);
            for (int j = i + 1; j < lastIndex; j++) {
                lastIndex = Math.max(lastIndex, S.lastIndexOf(S.charAt(j)));
            }
            ret.add(lastIndex - i + 1);
            i = lastIndex;
        }
        return ret;
    }
}
