class Solution {
    public static String maskEmail(String email) {
        String [] splits = email.toLowerCase().split("@");
        
        StringBuilder sb = new StringBuilder();
        sb.append(splits[0].charAt(0)).append("*****").append(splits[0].charAt(splits[0].length() - 1)).append("@").append(splits[1]);
        
        return sb.toString();
    }
    
    public static String maskPhoneNumber(String phoneNumber) {
        phoneNumber = phoneNumber.replaceAll("[^0-9]", "");
        StringBuilder sb = new StringBuilder();
        if (phoneNumber.length() == 10) {
            sb.append("***-***-").append(phoneNumber.substring(6));
        } else {
            sb.append('+');
            for (int i = 0; i < phoneNumber.length() - 10; i++) {
                sb.append('*');
            }
            sb.append("-***-***-");
            sb.append(phoneNumber.substring(sb.length() - 4));
        }
        return sb.toString();
    }
    
    public static String maskPII(String S) {
        if (S.contains("@")) {
            return maskEmail(S);
        }
        return maskPhoneNumber(S);
    }
}
