class Solution {
    public int countComponents(int n, int[][] edges) {
        int components = 0;
        List<Integer>[] adjList = new ArrayList[n];
        
        for(int i=0; i<n; i++){
            adjList[i] = new ArrayList<Integer>();
        }
        
        for(int i=0; i<edges.length; i++){
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }
        
        int[] visited = new int[n];
        for(int i=0; i<adjList.length; i++){
            if(visited[i] == 0){
                components++;
                dfs(adjList, visited, i);
            }
        }
        return components;
    }
    
    
    public void dfs(List<Integer>[] adjList, int[] visited, int curr){
        visited[curr] = 1;
        
        for(int i=0; i<adjList[curr].size(); i++){
            if(visited[adjList[curr].get(i)] == 0){
                dfs(adjList, visited, adjList[curr].get(i));
            }
        }
    }
    
}