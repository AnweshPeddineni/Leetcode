class Solution {
    public int countBattleships(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'X') {
                    count++;
                    dfs(board, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] board, int i, int j) {
        // Base case: Out of bounds or not part of a battleship
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '.') {
            return;
        }

        // Mark the cell as visited
        board[i][j] = '.';

        // Explore all four directions (up, down, left, right)
        dfs(board, i - 1, j); // Up
        dfs(board, i + 1, j); // Down
        dfs(board, i, j - 1); // Left
        dfs(board, i, j + 1); // Right
    }
}

// The idea is to traverse the grid and use DFS to "sink" a detected battleship. When a cell with 'X' is found:
