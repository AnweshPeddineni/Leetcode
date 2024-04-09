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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base condition - if the root is null, return null
        if(root == null) return null;
        
        // If both p and q are greater than root, LCA must be in the right subtree
        if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        // If both p and q are less than root, LCA must be in the left subtree
        else if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        // If neither of the above, root is the LCA
        else{
            return root;
        }
    }
}
