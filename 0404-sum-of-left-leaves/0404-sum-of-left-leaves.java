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
    
    private int leftLeafSum = 0;
    
    public int sumOfLeftLeaves(TreeNode root) {
        helper(root);
        return leftLeafSum;        
    }
    
    private void helper(TreeNode node){
        
        if(node == null) return;
        
        helper(node.left);
        
        if(node.left != null && node.left.left == null && node.left.right == null){
            leftLeafSum += node.left.val;
        }
        
        helper(node.right);
        
        
                
    }
    
}