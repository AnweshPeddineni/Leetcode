import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // **Adjacency list: graph[u] = list of (v, w) edges**
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] t : times) {
            int from = t[0];
            int to = t[1];
            int weight = t[2];
            graph.get(from).add(new int[]{to, weight});
        }

        // **Distance array — shortest time from k to each node**
        int[] minTime = new int[n + 1];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        minTime[k] = 0;

        // **Min‑heap based on shortest current distance**
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[1], b[1])
        );
        pq.offer(new int[]{k, 0});  // {node, currentDistance}

       while(!pq.isEmpty()){
        int[] nearest = pq.poll();
        int node = nearest[0];
        int weight = nearest[1];
        
        if(graph.get(node) != null){
            for(int[] neighbor: graph.get(node)){
                if(weight+neighbor[1] < minTime[neighbor[0]]){
                   minTime[neighbor[0]] =  weight+neighbor[1];
                   pq.offer(new int[] {neighbor[0], minTime[neighbor[0]]});
                }
            }
        }
       }

        // Find the maximum shortest time
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (minTime[i] == Integer.MAX_VALUE) return -1; // unreachable
            result = Math.max(result, minTime[i]);
        }

        return result;
    }
}

// Time complexity : O(E*log V)
// Space complexity : O(V+E)
