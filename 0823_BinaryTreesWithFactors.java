class Solution {
    public static int numFactoredBinaryTrees(int[] A) {
        Arrays.sort(A);
        HashMap<Integer, Long> map = new HashMap<>();
        int num;
        int a, b;
        long res;
        for (int i = 0; i < A.length; i++) {
            num = A[i];
            res = 1;
            for (int j = 0; j < i && A[j] * A[j] <= A[i]; j++) {
                if (num % A[j] == 0 && map.containsKey(num / A[j])) {
                    a = A[j];
                    b = num / A[j];
                    if (a == b) {
                        res += map.get(a) * map.get(a);
                        res %= 1000000007;
                    } else {
                        res += map.get(a) * map.get(b) * 2;
                        res %= 1000000007;
                    }
                }
            }
            map.put(num, res);
        }
        
        res = 0;
        for (Long value : map.values()) {
            res += value;
            res %= 1000000007;
        }
        return (int)res;
    }
}
