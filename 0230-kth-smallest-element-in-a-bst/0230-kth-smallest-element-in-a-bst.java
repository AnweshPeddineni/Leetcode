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
    
    private int count = 0;
    private int result = Integer.MIN_VALUE;
    
    public int kthSmallest(TreeNode root, int k) {
        traverseInOrder(root, k);
        return result;
    }
    
    private void traverseInOrder(TreeNode node, int k) {
        if(node == null) return;
        
        traverseInOrder(node.left, k);
        
        // Increment count on visiting a node
        count++;
        if(count == k) {
            result = node.val;
            // Return immediately once the kth smallest element is found
            return;
        }
        
        traverseInOrder(node.right, k);
    }
}

// class Solution {
//     public int kthSmallest(TreeNode root, int k) {
//         Stack<TreeNode> stack = new Stack<>();
        
//         while (true) {
//             // Go to the leftmost node
//             while (root != null) {
//                 stack.push(root);
//                 root = root.left;
//             }
            
//             // Process the node
//             root = stack.pop();
//             if (--k == 0) return root.val;
            
//             // Move to the right subtree
//             root = root.right;
//         }
//     }
// }
