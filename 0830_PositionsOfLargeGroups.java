class Solution {
    public static List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> list = new ArrayList<>();
        char last = ' ';
        int lastIndex = 0;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) != S.charAt(lastIndex)) {
                if (i - lastIndex > 2) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(lastIndex);
                    temp.add(i - 1);
                    list.add(temp);
                }
                lastIndex = i;
            }
        }
        if (S.length() - lastIndex > 2) {
            List<Integer> temp = new ArrayList<>();
            temp.add(lastIndex);
            temp.add(S.length() - 1);
            list.add(temp);

        }
        return list;
    }
}
