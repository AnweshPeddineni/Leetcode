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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        // Step 1: Create a map to store parent references for each node
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParentMap(root, null, parentMap);  // Recursively fill the parent map

        // Step 2: Initialize BFS
        Queue<TreeNode> queue = new LinkedList<>(); // For level-order traversal
        Set<TreeNode> visited = new HashSet<>();    // To prevent revisiting nodes

        queue.offer(target);      // Start BFS from the target node
        visited.add(target);      // Mark target as visited

        int level = 0;            // Tracks how far we are from the target

        // Step 3: Standard BFS loop
        while (!queue.isEmpty()) {
            int size = queue.size();

            // If we have reached distance k, stop expanding further
            if (level == k) break;

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                // Visit left child if it exists and is unvisited
                if (current.left != null && visited.add(current.left)) {
                    queue.offer(current.left);
                }

                // Visit right child if it exists and is unvisited
                if (current.right != null && visited.add(current.right)) {
                    queue.offer(current.right);
                }

                // Visit parent from the map if unvisited
                TreeNode parent = parentMap.get(current);
                if (parent != null && visited.add(parent)) {
                    queue.offer(parent);
                }
            }

            level++; // Move to the next level in BFS
        }

        // Step 4: Collect all nodes at distance k (they are now in the queue)
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll().val); // Extract values from nodes
        }

        return result;
    }

    // Recursive function to map each node to its parent
    private void buildParentMap(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> map) {
        if (node == null) return;

        map.put(node, parent);  // Store the parent of the current node

        buildParentMap(node.left, node, map);   // Recur for left child
        buildParentMap(node.right, node, map);  // Recur for right child
    }
}
