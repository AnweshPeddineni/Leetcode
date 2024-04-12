/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }
    
    private void serializeHelper(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("N,");
        }else{
            sb.append(root.val).append(",");
            serializeHelper(root.left, sb);
            serializeHelper(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        int[] index = new int[1]; // Use an array to hold the index so it can be mutated inside recursive calls
        return deserializeHelper(tokens, index);
    }
    
    private TreeNode deserializeHelper(String[] tokens, int[] index){
        if(index[0] == tokens.length) return null; // Protection against out of bounds
        String token = tokens[index[0]];
        index[0]++; // Increment index
        
        if(token.equals("N")){
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.parseInt(token));
        node.left = deserializeHelper(tokens, index);
        node.right = deserializeHelper(tokens, index);
        return node;
    }
}


// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));