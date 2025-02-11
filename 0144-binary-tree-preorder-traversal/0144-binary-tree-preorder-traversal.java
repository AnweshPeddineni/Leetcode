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

// Stack :  right  -> left -> root

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();

        List<Integer> result = new ArrayList<>();

        if(root == null){
           return result;
        }

        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();

            result.add(temp.val);

            if(temp.right != null){
                stack.push(temp.right);
            }

            if(temp.left != null){
                stack.push(temp.left);
            }

        }

        return result;
    }

}