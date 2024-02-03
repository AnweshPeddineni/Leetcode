class Solution {
    
    // adjacencyList represents the graph structure
    private List<List<Integer>> adjacencyList = new ArrayList<>();
    // seen is used to keep track of visited nodes
    private Set<Integer> seen = new HashSet<>();
    
    public boolean validTree(int n, int[][] edges) {
        // A tree should have exactly n-1 edges
        if(edges.length != n-1) return false;
        
        // Initialize adjacency list for each node
        for(int i = 0; i < n; i++){
            adjacencyList.add(new ArrayList<>());
        }
        
        // Build the graph (undirected) from the edge list
        for(int[] edge : edges){
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        
        // Start DFS from node 0. If we can visit all nodes exactly once, and there are no cycles, it's a valid tree.
        return dfs(0, -1) && seen.size() == n;
    }
    
    // DFS function to traverse the graph
    public boolean dfs(int node, int parent){
        // If the node is already visited, it's not a valid tree (cycle detected)
        if(seen.contains(node)) return false;
        // Mark the node as seen
        seen.add(node);
        // Visit all the neighbors
        for(int neighbour : adjacencyList.get(node)){
            // Skip the parent node to prevent immediate backtracking which is not actually a cycle
            if(parent != neighbour){
                boolean result = dfs(neighbour, node); // Recursive DFS call
                if(!result) return false; // If any subtree contains a cycle, the whole graph is not a tree
            }   
        }
        // If no cycle is detected in the subtree rooted at this node, return true
        return true;
    }
}
