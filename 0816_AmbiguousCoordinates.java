class Solution {
    public static List<String> ambiguousCoordinates(String S) {
        S = S.substring(1, S.length() - 1);
        String a, b;
        List<String> l1, l2;
        List<String> result = new ArrayList<>();
        for (int i = 1; i < S.length(); i++) {
            a = S.substring(0, i);
            b = S.substring(i, S.length());
            l1 = generateNums(a);
            l2 = generateNums(b);
            for (String aa : l1) {
                for (String bb : l2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append('(');
                    sb.append(aa);
                    sb.append(',');
                    sb.append(' ');
                    sb.append(bb);
                    sb.append(')');
                    result.add(sb.toString());
                }
            }
        }
        return result;
    }
    
    public static List<String> generateNums(String num) {
        String temp;
        List<String> ret = new ArrayList<>();
        if (isValid(num)) ret.add(num);
        for (int i = 1; i < num.length(); i++) {
            temp = num.substring(0, i) + "." + num.substring(i, num.length());
            if (isValid(temp)) ret.add(temp);
        }
        return ret;
    }
    
    public static boolean isValid(String num) {
        if (num.contains(".")) {
            if (num.startsWith("0") && !num.startsWith("0.")) return false;
            double d = Double.parseDouble(num);
            return d % 1 != 0 && !num.endsWith("0");
        } else {
            return String.valueOf(Integer.parseInt(num)).equals(num);
        }
    }
}
