class Solution {
    public int findJudge(int n, int[][] trust) {
        
        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[n+1];

        for(int i=0; i<=n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<trust.length; i++){
             adjList.get(trust[i][0]).add(trust[i][1]);
             indegree[trust[i][1]]++;
        }

        int result = -1;

        for(int i=0; i<=n; i++){
           if(indegree[i] == n-1 && adjList.get(i).isEmpty()) result = i;
        }

        return result;
    }
}

//Input: n = 3, trust = [[1,3],[2,3],[3,1]]
//Output: -1