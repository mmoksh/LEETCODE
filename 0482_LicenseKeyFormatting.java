class Solution {
    public static String licenseKeyFormatting(String S, int K) {
        S = S.replaceAll("-", "").toUpperCase();
        if (S.length() == 0) return "";
        int mod = S.length() % K;
        StringBuilder sb = new StringBuilder(S.length() + S.length() / K);
        if (mod == 0) {
            mod = K;
        }
        
        for (int i = 0; i < mod; i++) {
            sb.append(S.charAt(i));
        }
        for (int i = mod; i < S.length(); i += K) {
            sb.append("-");
            for (int j = i; j < i + K; j++) {
                sb.append(S.charAt(j));
            }
        }
        return sb.toString();
    }
}
