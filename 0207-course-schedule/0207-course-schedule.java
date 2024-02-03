class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create an adjacency list to represent the graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Fill the adjacency list with prerequisites
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        // Create an array to track the visit state of each course
        // 0 - not visited, 1 - visited, 2 - currently visiting
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            // If not visited, check for cycles
            if (visited[i] == 0) {
                if (isCyclic(adj, visited, i)) {
                    // If a cycle is found, return false
                    return false;
                }
            }
        }
        // If no cycles found, return true
        return true;
    }

    private boolean isCyclic(List<List<Integer>> adj, int[] visited, int curr) {
        // If currently visiting, it's a cycle
        if (visited[curr] == 2) {
            return true;
        }

        // Mark the current course as currently visiting
        visited[curr] = 2;
        for (int i = 0; i < adj.get(curr).size(); i++) {
            // If the neighbor is not fully visited
            if (visited[adj.get(curr).get(i)] != 1) {
                // Recursively visit the neighbor
                if (isCyclic(adj, visited, adj.get(curr).get(i))) {
                    return true;
                }
            }
        }
        // After visiting all neighbors, mark as fully visited
        visited[curr] = 1;
        return false;
    }
}
