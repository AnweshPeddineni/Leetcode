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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        
        TreeNode newNode = new TreeNode(val);
        
        if(depth == 1){
           newNode.left = root;
           return newNode;
        }
        
        constructNewLevel(root, val, depth, 1);
        return root;
    
    }
    
    private void constructNewLevel(TreeNode node, int val, int depth, int currentDepth){
        
        if(node == null) return;
        
        if(currentDepth > depth-1) return;
        
        if(currentDepth == depth-1){
            
            TreeNode tempLeft = node.left;
            node.left = new TreeNode(val);
            node.left.left = tempLeft;
            
            TreeNode tempRight = node.right;
            node.right = new TreeNode(val);
            node.right.right = tempRight;
        }
        
        
        constructNewLevel(node.left, val, depth, currentDepth + 1);
        
       
        constructNewLevel(node.right, val, depth, currentDepth + 1);
        
      
        
    }
}






