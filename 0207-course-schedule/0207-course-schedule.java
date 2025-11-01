class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];

        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0; i<numCourses; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<prerequisites.length; i++){
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        int visited = 0;

        while(!queue.isEmpty()){
            for(int i=0; i<queue.size(); i++){
                int currCourse = queue.poll();
                visited++;
                for(int neighbor : adjList.get(currCourse)){
                    if(indegree[neighbor] > 0){
                        indegree[neighbor]--;
                        if(indegree[neighbor] == 0){
                            queue.add(neighbor);
                        }
                    }
                }
            } 
        }
        return visited == numCourses;
    }
}