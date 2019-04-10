class Solution {
    public static String reorganizeString(String S) {
        int[] hist = new int[26];
        for (int i = 0; i < S.length(); i++) {
            hist[S.charAt(i) - 'a']++;
        }

        C[] counts = new C[26];
        for (int i = 0; i < 26; i++) {
            counts[i] = new C((char) (i + 'a'), hist[i]);
        }

        int index = 0;
        char[] ret = new char[S.length()];

        PriorityQueue<C> pq = new PriorityQueue<>();
        for (C count : counts) {
            if (count.count != 0) {
                pq.add(count);
            }
        }

        C last = null;
        while (index < ret.length) {
            C a = pq.poll();

            if (last == a) {
                if (pq.isEmpty()) {
                    return "";
                }
                C b = pq.poll();
                pq.add(a);
                a = b;
            }

            last = a;
            ret[index++] = a.c;
            a.count--;
            if (a.count > 0) {
                pq.add(a);
            }
        }

        return String.valueOf(ret);
    }

    static class C implements Comparable<C> {
        char c;
        int count;

        public C(char c, int count) {
            this.c = c;
            this.count = count;
        }

        @Override
        public int compareTo(C o) {
            return o.count - this.count;
        }
    }
}
