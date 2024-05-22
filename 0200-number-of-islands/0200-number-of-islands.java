class Solution {
    
    boolean[][] visited;
    char[][] grid;
    
    
    public int numIslands(char[][] grid) {
       int m = grid.length;
       int n = grid[0].length;
       this.grid = grid;
       this.visited = new boolean[m][n];
        
       int count = 0;
       
       for(int i = 0; i<m; i++){
           for(int j=0; j<n; j++){
               if(!visited[i][j] && grid[i][j] == '1'){
                   count++;
                   dfs(i,j);
               }
           }
       }
       return count;
    }
    
    public void dfs(int row, int col){
        if(row >= grid.length || row < 0 || col >= grid[0].length || col < 0 || grid[row][col] == '0'){
            return;
        }
        
        if(visited[row][col] == true){
            return;
        }
        
        visited[row][col] = true;
        
        dfs(row+1, col);
        dfs(row, col+1);
        dfs(row-1, col);
        dfs(row, col-1);
    }
}