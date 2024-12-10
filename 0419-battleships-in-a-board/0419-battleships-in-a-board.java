class Solution {
    public int countBattleships(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Check if this cell is part of a battleship
                if (board[i][j] == 'X') {
                    // Check if it's the start of a new battleship
                    if (i > 0 && board[i - 1][j] == 'X') continue; // Skip if there's an 'X' above
                    if (j > 0 && board[i][j - 1] == 'X') continue; // Skip if there's an 'X' to the left

                    // This is a new battleship
                    count++;
                }
            }
        }

        return count;
    }
}
