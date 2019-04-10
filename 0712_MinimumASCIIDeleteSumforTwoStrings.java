class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int [][] matrix = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + s1.charAt(i - 1);
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }
        
        int ret = matrix[s1.length()][s2.length()] * -2;
        
        for (int k = 0; k < s1.length(); k++) {
            ret += s1.charAt(k);
        }
        for (int k = 0; k < s2.length(); k++) {
            ret += s2.charAt(k);
        }
        
        return ret;
    }
}
