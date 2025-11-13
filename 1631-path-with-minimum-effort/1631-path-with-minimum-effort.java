class Solution {
    
    public int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public int minimumEffortPath(int[][] heights) {
       
        int minSpike = 0;
        int maxSpike = 1000000;

        while(minSpike < maxSpike){
           int mid = minSpike + (maxSpike-minSpike)/2;

           boolean[][] visited = new boolean[heights.length][heights[0].length];

           if(dfs(heights, mid, 0, 0, visited)){
              maxSpike = mid;
           }else{
              minSpike = mid+1;
           }
        }
        return minSpike;
    }
    //      R
    //        L
    // [0,1,2,3,4,5] Ans = 3
    //        M



    public boolean dfs(int[][] heights, int spikeLimit, int i, int j, boolean[][] visited){  
        if(i == heights.length-1 && j == heights[0].length-1) return true;

        visited[i][j] = true;

        for(int[] dir : dirs){        
                int row = i+dir[0];
                int col = j+dir[1];
                if(row<0 || row>=heights.length || col<0 || col>=heights[0].length){
                    continue;
                }
                if(visited[row][col]) continue;
                if(Math.abs(heights[i][j] - heights[row][col]) <= spikeLimit){
                    if (dfs(heights, spikeLimit, row, col, visited)) return true;
                }
        }
        return false;
    }
}

// spike(Max) = 1000000;

// return -> will be some where between Max and Min

// spike(Min) = 0;

// Pattern -> Binary Search while(left<=right) find the minimum spike 