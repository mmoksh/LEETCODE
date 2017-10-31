import java.util.*;
class Solution {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (sb.length() < B.length()) {
            sb.append(A);
            count++;
        }
        if (sb.indexOf(B) >= 0) {
            return count;
        }
        sb.append(A);
        return sb.indexOf(B) >= 0? count + 1: -1;
    }
}
