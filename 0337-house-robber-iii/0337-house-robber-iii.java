/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  
            // Main method that calculates the maximum money that can be robbed
    int rob(TreeNode root) {
        // Perform DFS traversal and collect both options: rob or skip
        int[] options = travel(root);
        // Return the maximum of both options
        return Math.max(options[0], options[1]);
    }

    // Recursive DFS function to calculate rob and skip values
    private int[] travel(TreeNode root) {
        // Base case: If node is null, return {0, 0} because nothing can be robbed
        if (root == null)
            return new int[2];

        // Recursively calculate values for left and right child nodes
        int[] left_node_choices = travel(root.left);
        int[] right_node_choices = travel(root.right);

        // Create an array to store two choices
        int[] options = new int[2];

        // Option 1: Rob the current node
        // - Add current node's value
        // - Add values when children not included(left_node_choices[1] and right_node_choices[1]) [1] -> not included, [0] -> included
        options[0] = root.val + left_node_choices[1] + right_node_choices[1];

        // Option 2: Skip the current node
        // - Add the maximum profit from robbing or skipping left and right children
        options[1] = Math.max(left_node_choices[0], left_node_choices[1]) +
                     Math.max(right_node_choices[0], right_node_choices[1]);

        // Return the array with both choices
        return options;
    
    }
}