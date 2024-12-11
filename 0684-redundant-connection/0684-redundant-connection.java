class Solution {
    
    int[] parent;
    
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        
        parent = new int[n+1];
        
        for(int i=0; i<=n; i++){
            parent[i] = i;
        }
        
        for(int[] edge : edges){
            if(find(edge[0]) == find(edge[1])) return edge;
            union(edge[0], edge[1]);
        }
        return null;
        
    }
    
    public int find(int x){
        while(parent[x] != x){
            x = parent[x];
        }
        return x;
    }
    
    public void union(int x, int y){
        int xRoot = find(x);
        int yRoot = find(y);
        
        if(xRoot != yRoot){
          parent[yRoot] = xRoot;
        }
    }
}