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
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        
        dfs(result, root);

        return result;
    }

    private void dfs(ArrayList<Integer> result, TreeNode root){
        if(root == null) return;

       
        result.add(root.val);
         dfs(result, root.left);
        dfs(result, root.right);
    }
}