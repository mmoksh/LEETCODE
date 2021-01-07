class Solution {
    public int countPairs(int[] deliciousness) {
        HashMap<Integer, Integer> hist = new HashMap<>();
        int max = 0;
        for (int d: deliciousness) {
            hist.put(d, hist.getOrDefault(d, 0) + 1);
            max = Math.max(max, d);
        }
        int pows = 1 << 21;
        while (pows > max * 2) {
            pows >>= 1;
        }
        long temp;
        long total = 0;
        while (pows > 0) {
            for (Map.Entry<Integer, Integer> entry: hist.entrySet()) {
                int a = entry.getKey();
                int b = pows - a;
                if (!hist.containsKey(b) || b > a) continue;
                temp = entry.getValue();
                if (a == b) {
                    temp = temp * (temp - 1) / 2;
                } else {
                    temp = temp * hist.get(b);
                }
                total = (total + temp % 1000000007) % 1000000007;
            }
            pows >>= 1;
        }
        
        return (int)total;
    }
}
