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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        
     return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);       
        
     //         1
     //        / \
     //       2   3
     //      /\   /\ 
     //     4  5 6  7       
     //             r    r  le ri  r  le ri
     // preorder = [1,   2, 4,5    3, 6,7]
     //            le r ri  r  le r ri
     // inorder = [4,2,5,  1,  6,3,7]               
        
    }
    
    public TreeNode helper(int[] preorder, int prestart, int preend,
                          int[] inorder, int instart, int inend){
        
        // base case
      if(prestart > preend || instart > inend)  return null;
        
      int val = preorder[prestart];
        
      TreeNode root = new TreeNode(val);
        
      
      int inorderRootIndex = instart;
       
      while(inorder[inorderRootIndex] != val){
          inorderRootIndex++;
      }
        
      int leftSubTreeSize = inorderRootIndex - instart;
      
    
      root.left = helper(preorder, prestart + 1, prestart + leftSubTreeSize,
                        inorder, instart, inorderRootIndex-1);
        
      
      root.right = helper(preorder, prestart + leftSubTreeSize + 1, preend,
                         inorder, inorderRootIndex+1, inend);
           
      return root;     
        
    }
    
}