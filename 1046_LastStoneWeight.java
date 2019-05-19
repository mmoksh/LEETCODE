class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            pq.add(stone);
        }
        int y, x;
        while (pq.size() > 1) {
            y = pq.poll();
            x = pq.poll();
            if (y != x) pq.add(y - x);
        }
        return pq.isEmpty()? 0: pq.poll();
    }
}
