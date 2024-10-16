// using Path Compression and Union by rank(Time Complexity: O(V+E))
class Solution {
    
    int[] parent;
    int[] rank;
    
    public int countComponents(int n, int[][] edges) {
       
        parent = new int[n];
        rank = new int[n];
        
        // Step 1: Initialize parent and rank arrays
        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 1; // Initialize rank to 1 for all nodes
        }
            
        // Step 2: Process each edge and perform unions
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            // Find the root parents of u and v
            int rootU = find(u);
            int rootV = find(v);
            
            // If roots are different, perform Union
            if(rootU != rootV) {
                union(rootU, rootV);
            }        
        }
            
        // Step 3: Count the number of unique root parents
        int count = 0;
        for(int i = 0; i < n; i++){
            if(parent[i] == i){
                count++;
            }
        }
        return count;
    }
    
    // Find with Path Compression
    public int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]); // Path Compression
        }
        return parent[x];
    }
    
    // Union with Union by Rank
    public void union(int x, int y){
        // x and y are already root parents
        if(rank[x] < rank[y]){
            parent[x] = y;
        }
        else if(rank[x] > rank[y]){
            parent[y] = x;
        }
        else{
            parent[y] = x;
            rank[x]++;
        }
    }
}