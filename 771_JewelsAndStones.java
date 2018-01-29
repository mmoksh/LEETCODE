class Solution {
    public static int numJewelsInStones(String J, String S) {
        char [] j = J.toCharArray();
        char [] s = S.toCharArray();
        int count = 0;
        for (char c : j) {
            for (char d : s) {
                if (c == d) count++;
            }
        }
        return count;
    }
}
