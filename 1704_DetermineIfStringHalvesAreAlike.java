class Solution {
    public boolean halvesAreAlike(String s) {
        s = s.toLowerCase();
        int[] hist = new int[26];
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    hist[s.charAt(i) - 'a'] += i * 2 < s.length() ? 1 : -1;
            }
        }
        int sum = 0;
        for (int num: hist) {
            sum += num;
        }
        return sum == 0;
    }
}
