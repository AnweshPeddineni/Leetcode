class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i=0; i<numCourses; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int i=0; i<prerequisites.length; i++){
            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        // 0->not visited, 1->currently visiting, 2->visited
        int[] visited = new int[numCourses];
        
        for(int i=0; i<numCourses; i++){
            if(visited[i] == 0){
                if(isCyclic(adjList, visited, i)){
                    return false;  // Cycle detected
                }
            }
        } 
        return true; // No cycles detected
    }
    
    public boolean isCyclic(List<List<Integer>> adjList, int[] visited, int curr){
        if(visited[curr] == 1){
            return true;  // Cycle detected
        }
        
        visited[curr] = 1; // Mark as currently visiting
        
        for(int num : adjList.get(curr)){
            if(visited[num] != 2){
                if(isCyclic(adjList, visited, num)){  // Check return value
                    return true;                        // Propagate cycle detection
                }
            } 
        }
        
        visited[curr] = 2; // Mark as fully visited
        return false;       // No cycle detected in this path
    }
}
