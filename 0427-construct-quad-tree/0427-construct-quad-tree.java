/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return buildTree(grid, 0, 0, grid.length);  // Start recursion
    }

    // Recursive function to construct Quad-Tree
    private Node buildTree(int[][] grid, int row, int col, int size) {
        // Step 1: Base Case - Check if the grid section has uniform values
        if (isUniform(grid, row, col, size)) {
            return new Node(grid[row][col] == 1, true);  // Create a leaf node
        }

        // Step 2: Divide the grid into four quadrants
        int newSize = size / 2;

        // Recursive calls for four sub-grids
        Node topLeft = buildTree(grid, row, col, newSize);
        Node topRight = buildTree(grid, row, col + newSize, newSize);
        Node bottomLeft = buildTree(grid, row + newSize, col, newSize);
        Node bottomRight = buildTree(grid, row + newSize, col + newSize, newSize);

        // Step 3: Create a non-leaf node with the four child nodes
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    // Helper function to check if the given grid section is uniform (all 1's or all 0's)
    private boolean isUniform(int[][] grid, int row, int col, int size) {
        int val = grid[row][col];  // First cell's value
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (grid[i][j] != val) {
                    return false;  // Found a different value
                }
            }
        }
        return true;  // All values are uniform
    }
}