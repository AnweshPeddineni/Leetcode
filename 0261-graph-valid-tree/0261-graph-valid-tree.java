class Solution {
    
    int[] parent;
    
    public boolean validTree(int n, int[][] edges) {
       
        
        parent = new int[n];
        
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        
        for(int[] edge : edges){
            if(find(edge[0]) == find(edge[1])) return false;
            union(edge[0], edge[1]);
        }
        int count = 0;
        for(int i=0; i<n; i++){
            if(parent[i] == i){
                count++;
            }
        }
        return count == 1;
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