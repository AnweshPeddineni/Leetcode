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
    public int goodNodes(TreeNode root) {
       return helper(root, root.val);
    }
    
    private int helper(TreeNode node, int maxValue) {
       if(node == null) return 0;
        
       int good = 0; 
        
       if(node.val >= maxValue){
           good++;
           maxValue = node.val;
       }
        
       int left = helper(node.left, maxValue);
       int right = helper(node.right, maxValue);
        
       return good + left + right; 
    }
    
}