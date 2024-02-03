class Solution {
    public int countComponents(int n, int[][] edges) {
        int components = 0; // Initialize count of components
        List<Integer>[] adjList = new ArrayList[n]; // Create an adjacency list for each node
        
        // Initialize adjacency list for each node
        for(int i=0; i<n; i++){
            adjList[i] = new ArrayList<Integer>();
        }
        
        // Populate the adjacency list with edges. For undirected graph, add edge in both directions.
        for(int i=0; i<edges.length; i++){
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }
        
        int[] visited = new int[n]; // Create a visited array to track visited nodes during DFS
        // Iterate through each node
        for(int i=0; i<adjList.length; i++){
            // If node is not visited, it's a new component. Do DFS from this node.
            if(visited[i] == 0){
                components++;
                dfs(adjList, visited, i);
            }
        }
        return components; // Return the number of connected components
    }
    
    // Helper DFS function to traverse nodes
    public void dfs(List<Integer>[] adjList, int[] visited, int curr){
        visited[curr] = 1; // Mark current node as visited
        
        // Traverse all neighbors of current node
        for(int i=0; i<adjList[curr].size(); i++){
            // If neighbor is not visited, visit it recursively
            if(visited[adjList[curr].get(i)] == 0){
                dfs(adjList, visited, adjList[curr].get(i));
            }
        }
    }
}
