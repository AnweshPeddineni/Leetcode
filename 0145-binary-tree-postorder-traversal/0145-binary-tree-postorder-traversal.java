class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>(); // ✅ Stores nodes in reversed Postorder (Root → Right → Left)

        List<Integer> result = new ArrayList<>();

        stack1.push(root); // ✅ Start with root node

        while (!stack1.isEmpty()) {
            TreeNode temp = stack1.pop();
            stack2.push(temp); // ✅ Store nodes in reverse postorder

            // ✅ Push left first, then right (to ensure right is processed first in stack2)
            if (temp.left != null) stack1.push(temp.left);
            if (temp.right != null) stack1.push(temp.right);
        }

        // ✅ Extract nodes from stack2 for correct Postorder (Left → Right → Root)
        while (!stack2.isEmpty()) {
            result.add(stack2.pop().val);
        }

        return result;
    }
}
