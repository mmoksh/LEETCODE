class Solution {
    // 1000100101111
    public int numSteps(String s) {
        int totalOps = 0;
        int l;
        while (!"1".equals(s)) {
            l = s.length() - 1;
            if (s.charAt(l) == '0') {
                s = s.substring(0, l);
                totalOps++;
                continue;
            }
            while (l >= 0 && s.charAt(l) == '1') {
                l--;
            }
            totalOps += s.length() - l;
            s = l >= 0 ? s.substring(0, l) + "1" : "1";
        }
        return totalOps;
    }
}
