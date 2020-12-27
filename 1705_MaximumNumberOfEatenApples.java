class Solution {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int total = 0;
        for (int i = 0; i < apples.length || !pq.isEmpty(); i++) {
            if (i < apples.length && apples[i] > 0) {
                pq.add(new int[] {apples[i], i + days[i]});
            }
            while (!pq.isEmpty() && pq.peek()[1] <= i) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                total++;
                pq.peek()[0]--;
                if (pq.peek()[0] == 0) pq.poll();
            }
        }
        return total;
    }
}
