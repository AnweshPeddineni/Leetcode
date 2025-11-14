import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        // Build adjacency list: graph[u] -> list of {v, price}
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] f : flights) {
            int from = f[0], to = f[1], price = f[2];
            graph.get(from).add(new int[]{to, price});
        }

        // Distance array: min cost to reach (city, stops)
        // We allow up to k+1 levels (since k stops => k+1 edges)
        int[][] bestCost = new int[n][k + 2];
        for (int[] row : bestCost) Arrays.fill(row, Integer.MAX_VALUE);
        bestCost[src][0] = 0;

        // Min-heap sorted by total cost so far
        // {city, totalCost, stopsUsed}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[1], b[1])
        );

        pq.offer(new int[]{src, 0, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int city = current[0];
            int costSoFar = current[1];
            int stopsUsed = current[2];

            // If we reached the destination with valid stop count
            if (city == dst) return costSoFar;

            // If we can't take more flights, skip
            if (stopsUsed > k) continue;

            // Relax all outgoing edges
            for (int[] edge : graph.get(city)) {
                int nextCity = edge[0];
                int price = edge[1];

                int newCost = costSoFar + price;

                // Only proceed if this is the cheapest we have seen
                if (newCost < bestCost[nextCity][stopsUsed + 1]) {
                    bestCost[nextCity][stopsUsed + 1] = newCost;
                    pq.offer(new int[]{nextCity, newCost, stopsUsed + 1});
                }
            }
        }

        return -1;
    }
}
