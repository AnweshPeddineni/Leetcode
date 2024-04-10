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
    public boolean isValidBST(TreeNode root) {
  
        return BSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean BSTHelper(TreeNode node, long min, long max){
     
        if (node == null) return true;
        
        if (min >= node.val || max <= node.val) {
            return false;
        }
        
        boolean leftSubTree = BSTHelper(node.left, min, node.val);
        boolean rightSubTree = BSTHelper(node.right, node.val, max);
        
        // Return true if both left and right subtrees are valid BSTs
        return leftSubTree && rightSubTree;
    }
}