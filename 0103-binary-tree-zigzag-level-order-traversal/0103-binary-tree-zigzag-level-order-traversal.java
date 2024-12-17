
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelList = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                levelList.add(current.val);

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }

            // Reverse the list if the current level is right-to-left
            if (!leftToRight) {
                Collections.reverse(levelList);
            }

            result.add(levelList);
            leftToRight = !leftToRight; // Toggle the direction
        }

        return result;
    }
}
