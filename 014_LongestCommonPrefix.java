class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int shortest_length = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            shortest_length = Math.min(shortest_length, strs[i].length());
        }
        int i = 0;
        outer:
        for (; i < shortest_length; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != strs[0].charAt(i)) {
                    break outer;
                }
            }
        }
        return strs[0].substring(0, i);
    }
}
