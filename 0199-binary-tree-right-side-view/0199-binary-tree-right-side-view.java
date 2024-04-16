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
    
    public List<Integer> rightSideView(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<>();
   
        ArrayList<Integer> result = new ArrayList<>();
        
        if(root==null) return result;
        
        queue.add(root);
        
        while(!queue.isEmpty()){
            
            int length = queue.size();
            
            for(int i=0; i<length; i++){
                
                TreeNode currentNode = queue.remove();
                
                
                if(i == length -1){
                    result.add(currentNode.val);
                }
                
                
                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }
                
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
                   
            }
            
        }
        
        return result;
        
    }
}