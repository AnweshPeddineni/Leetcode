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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        if(root == null){
            TreeNode addition = new TreeNode(val);
            return addition;
        }
        
        helper(root, val);
        return root;
        
    }

    public void helper(TreeNode root, int addVal){
        if(root == null) return;

        if(addVal > root.val){
            if(root.right == null){
               TreeNode addition = new TreeNode(addVal);
               root.right = addition;
               return;
            }
            helper(root.right, addVal);;
        }

        if(addVal < root.val){
            if(root.left == null){
               TreeNode addition = new TreeNode(addVal);
               root.left = addition;
               return;
            }
            helper(root.left, addVal);
        }

    }
}