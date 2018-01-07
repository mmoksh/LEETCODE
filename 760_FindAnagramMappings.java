class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            map.put(B[i], i);
        }
        int [] ret = new int[A.length];
        for (int i = 0; i < B.length; i++) {
            ret[i] = map.get(A[i]);
        }
        return ret;
    }
}
