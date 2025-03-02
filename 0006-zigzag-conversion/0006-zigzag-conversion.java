class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s; // ✅ If only one row or length too short, return as is.
        }

        int rows = numRows;
        int cols = s.length();  // ✅ Allocate enough columns to avoid out-of-bounds

        char[][] grid = new char[rows][cols];

        int row = 0;
        int col = 0;
        int direction = 1;  // ✅ 1 for downward, 0 for upward diagonal

        for (char c : s.toCharArray()) {          
            grid[row][col] = c;
            
            if (direction == 1) {  // ✅ Moving down
                row++;
                if (row == numRows - 1) {
                    direction = 0; // Switch to diagonal
                }
            } else {  // ✅ Moving diagonally up
                row--;
                col++;  // ✅ Move right when going up
                if (row == 0) {
                    direction = 1; // Switch to downward
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        // ✅ Collect characters row by row
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (Character.isLetter(grid[i][j]) ||
                    grid[i][j] == '.' ||
                    grid[i][j] == ',') { // ✅ Ignore empty characters
                    sb.append(grid[i][j]);
                }
            }
        }

        return sb.toString();
    }
}
