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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        ArrayList<List<Integer>> result = new ArrayList<>();
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        if(root == null) return result;
        
        queue.add(root);
        
        while(!queue.isEmpty()){
            ArrayList<Integer> level = new ArrayList<>();
            
            int length = queue.size();
            
            for(int i=0; i<length; i++){
                TreeNode currNode = queue.poll();
                level.add(currNode.val);
                
                // Add the node's children to the queue for the next level
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
            result.add(level);    
        }
        
        return result;  
    }
}