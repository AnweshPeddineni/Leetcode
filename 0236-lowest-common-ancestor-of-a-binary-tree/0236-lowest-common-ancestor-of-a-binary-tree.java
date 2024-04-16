/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    private TreeNode result = new TreeNode();
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        helper(root, p, q);
        
        return result;
    }
    
    private boolean helper(TreeNode node, TreeNode p, TreeNode q){
      
        if(node == null) return false;
        
        
        boolean leftFind = helper(node.left, p, q);
            
        boolean rightFind = helper(node.right, p, q);
        
        boolean nodeIsPOrQ = (node == p || node == q);
        
        if(leftFind && rightFind || leftFind && nodeIsPOrQ || rightFind && nodeIsPOrQ){
            result = node;
        }
        
        return leftFind || rightFind || nodeIsPOrQ;
    }
}