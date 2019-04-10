class Solution {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        List<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList();
        }
        for (int[] flight : flights) {
            graph[flight[0]].add(new Edge(flight[1], flight[2]));
            graph[flight[1]].add(new Edge(flight[0], 10000000));
        }
        int[] hops = fillHops(n, graph, dst);
        return dijkstra(graph, hops, src, dst, K);
    }

    public static int[] fillHops(int n, List<Edge>[] graph, int dst) {
        int[] hops = new int[n];
        Arrays.fill(hops, 1000);
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.add(dst);
        visited[dst] = true;
        hops[dst] = 0;
        int size, temp, h = 0;
        while (!q.isEmpty()) {
            size = q.size();
            for (int i = 0; i < size; i++) {
                temp = q.poll();
                for (Edge edge : graph[temp]) {
                    if (edge.price == 10000000 && !visited[edge.id]) {
                        q.add(edge.id);
                        hops[edge.id] = h;
                        visited[edge.id] = true;
                    }
                }
            }
            h++;
        }
        return hops;
    }

    private static int dijkstra(List<Edge>[] graph, int[] hops, int src, int dst, int K) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] prices = new int[graph.length];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        
        pq.add(new Node(src, 0, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (node.id == dst) {
                return node.price;
            }
            if (node.price > prices[node.id]) {
                continue;
            }
            
            prices[node.id] = node.price;
            for (Edge edge : graph[node.id]) {
                if (edge.price == 10000000) {
                    continue;
                }
                if (prices[node.id] + edge.price >= prices[edge.id]) {
                    continue;
                }
                if (node.hops + hops[edge.id] > K) {
                    continue;
                }
                prices[edge.id] = prices[node.id] + edge.price;
                Node n = new Node(edge.id, prices[edge.id], node.hops + 1);
                pq.add(n);
            }
        }
        return -1;
    }

    static class Edge {

        int id;
        int price;

        public Edge(int id, int price) {
            this.id = id;
            this.price = price;
        }
    }

    static class Node implements Comparable<Node> {

        int id;
        int price;
        int hops;

        public Node(int id, int price, int hops) {
            this.id = id;
            this.price = price;
            this.hops = hops;
        }

        @Override
        public int compareTo(Node o) {
            return this.price - o.price;
        }
    }
}
