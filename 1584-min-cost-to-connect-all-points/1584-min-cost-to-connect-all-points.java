// optimized prims algo: Time Complexity: O(N^2) where N is the number of points

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;       // Total number of points
        int mstCost = 0;             // Accumulates the total cost of the MST
        int edgesUsed = 0;           // Counts the number of edges included in the MST
        
        // Boolean array to track whether a node is included in the MST
        boolean[] inMST = new boolean[n];
        
        // Array to store the minimum distance of each node to the MST
        int[] minDist = new int[n];
        minDist[0] = 0; // Start from the first point with a distance of 0
        
        // Initialize the minDist array:
        // For all other points, set the initial distance to infinity
        for (int i = 1; i < n; ++i) {
            minDist[i] = Integer.MAX_VALUE;
        }
        
        // Iterate until all points are included in the MST
        while (edgesUsed < n) {
            int currMinEdge = Integer.MAX_VALUE; // Stores the smallest edge weight found in this iteration
            int currNode = -1;                   // Stores the index of the node with the smallest edge
            
            // Find the node with the smallest edge weight that is not yet included in the MST
            for (int node = 0; node < n; ++node) {
                if (!inMST[node] && currMinEdge > minDist[node]) {
                    currMinEdge = minDist[node];
                    currNode = node;
                }
            }
            
            // Add the smallest edge weight to the total MST cost
            mstCost += currMinEdge;
            edgesUsed++;                        // Increment the count of edges included in the MST
            inMST[currNode] = true;             // Mark the current node as included in the MST
            
            // Update the minimum distances of the adjacent nodes to the current node
            for (int nextNode = 0; nextNode < n; ++nextNode) {
                // Calculate the Manhattan distance between the current node and the next node
                int weight = Math.abs(points[currNode][0] - points[nextNode][0]) + 
                             Math.abs(points[currNode][1] - points[nextNode][1]);
                
                // If the next node is not in MST and the calculated distance is less than its current minDist
                if (!inMST[nextNode] && minDist[nextNode] > weight) {
                    minDist[nextNode] = weight; // Update the minDist for the next node
                }
            }
        }
        
        return mstCost; // Return the total cost of connecting all points
    }
}
