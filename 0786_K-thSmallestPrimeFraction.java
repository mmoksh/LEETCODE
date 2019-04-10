class Solution {
    public static int[] kthSmallestPrimeFraction(int[] A, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> {
            return A[a[0]] * A[b[1]] >= A[b[0]] * A[a[1]] ? 1 : -1;
        });
        
        int max = A[A.length - 1];
        for (int i = 0; i < A.length - 1; i++) {
            pq.add(new int[]{i, A.length - 1});
        }
        
        int [] arr = null;
        while (K-- > 0) {
            arr = pq.poll();
            if (arr[0] + 1 < arr[1]) {
                pq.add(new int[]{arr[0], arr[1] - 1});
            }
        }
        return new int[]{A[arr[0]], A[arr[1]]};
    }
}
