public class Solution {

    public int minCostConnectPoints(int[][] points) {
        // Number of points (nodes) in the complete graph
        int n = points.length;
        if (n <= 1) return 0; // Trivial cases: 0 or 1 point → cost 0

        // 'node' = current node chosen in the MST growth (start at 0)
        int node = 0;

        // dist[i] = cheapest known edge to connect node i to the current MST
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // visit[i] = whether node i is already included in the MST
        boolean[] visit = new boolean[n];

        // 'edges' counts how many edges have been added to the MST so far (target is n-1)
        // 'res' accumulates the total MST cost
        int edges = 0, res = 0;

        // Prim's (array-based) runs exactly (n - 1) additions after the start node
        while (edges < n - 1) {
            // Mark the current node as included in the MST
            visit[node] = true;

            // We'll choose the next node with the smallest connecting cost
            int nextNode = -1;

            // For every not-yet-in-MST node, try to relax its best edge via 'node'
            for (int i = 0; i < n; i++) {
                if (visit[i]) continue; // skip nodes already in MST

                // Cost to connect i using the newly added 'node'
                int curDist = manhattan(points[i], points[node]);

                // Keep the smallest edge seen so far to reach i from the MST
                dist[i] = Math.min(dist[i], curDist);

                // Track the not-yet-visited node with the minimal connection cost
                if (nextNode == -1 || dist[i] < dist[nextNode]) {
                    nextNode = i;
                }
            }

            // Add that cheapest edge to the total cost
            res += dist[nextNode];

            // Move on: grow the MST from the chosen next node
            node = nextNode;
            edges++;
        }

        // Total cost of the Minimum Spanning Tree (MST)
        return res;
    }

    // Helper: Manhattan distance between two points a and b
    private int manhattan(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}

// O(n^2) time (n iterations × linear scans/relaxes) and O(n) extra space.

// Not all elements in the dist array will be updated in every iteration. In fact, only some of them will typically get updated each time.

// Here’s why:

// When you add a new node to the MST, you look at all the nodes that are not yet included in the MST and see if the newly added node offers a cheaper connection to them than what they had before. If it does, you update the dist value for those nodes. If it doesn’t, you leave those nodes’ dist values unchanged.

// So in each iteration:

// Some nodes’ dist values will be updated—those are the nodes for which the newly added node provides a cheaper connection.

// Other nodes’ dist values will remain the same—if the cost to connect them hasn’t improved, you just leave their dist values as they are.

// In other words, the dist array is selectively updated only where the new node offers a better (cheaper) connection. This is what makes the algorithm efficient—you don’t need to re-initialize or re-compute everything from scratch each time, just update what needs to be updated.
