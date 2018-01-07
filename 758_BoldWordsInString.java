class Solution {
    public static String boldWords(String[] words, String S) {
        boolean[] b = new boolean[S.length()];
        int start = 0;
        int index = -1;
        for (String word : words) {
            start = 0;

            index = S.indexOf(word, start);

            while (index >= 0) {
                start = index + 1;
                for (int i = index; i < index + word.length(); i++) {
                    b[i] = true;
                }
                index = S.indexOf(word, start);
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean open = false;
        for (int i = 0; i < b.length; i++) {
            if (b[i]) {
                if (!open) {
                    open = true;
                    sb.append("<b>");
                }
                sb.append(S.charAt(i));
            } else {
                if (open) {
                    open = false;
                    sb.append("</b>");
                }
                sb.append(S.charAt(i));
            }
        }
        if (open) {
            open = false;
            sb.append("</b>");
        }
        return sb.toString();
    }
}
