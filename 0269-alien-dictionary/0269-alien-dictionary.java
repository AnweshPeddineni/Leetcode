class Solution {
    
    // Initialize an adjacency list to represent the graph of characters.
    private Map<Character, List<Character>> reverseAdjList = new HashMap<>();
    // Map to keep track of visited nodes to detect cycles.
    private Map<Character, Boolean> seen = new HashMap<>();
    // StringBuilder to accumulate characters in the correct order.
    private StringBuilder output = new StringBuilder();
    
    public String alienOrder(String[] words) {
        
        // Step 0: Populate the adjacency list with all unique characters.
        for (String word : words) {
            for (char c : word.toCharArray()) {
                reverseAdjList.putIfAbsent(c, new ArrayList<>());
            }
        }
        
        // Step 1: Construct the graph by adding edges based on the order in words.
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            // Edge case: check if word2 is a prefix of word1, which is invalid.
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            // Find the first different character and create an edge in the graph.
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    reverseAdjList.get(word2.charAt(j)).add(word1.charAt(j));
                    break;
                }
            }
        }
        
        // Step 2: Perform DFS to detect cycles and build the output string.
        for (Character c : reverseAdjList.keySet()) {
            boolean result = dfs(c);
            if (!result) return ""; // Cycle detected.
        }
        
        // If no cycle was detected, return the characters in reverse postorder.
        return output.toString();
    }
    
    // Helper function to perform DFS and detect cycles.
    private boolean dfs(Character c) {
        if (seen.containsKey(c)) {
            return seen.get(c); // Return false if a cycle is detected (grey node).
        }
        seen.put(c, false); // Mark node as grey (currently visiting).
        for (Character next : reverseAdjList.get(c)) {
            boolean result = dfs(next);
            if (!result) return false; // Cycle detected.
        }
        seen.put(c, true); // Mark node as black (visited).
        output.append(c); // Append character to the output.
        return true;
    }    
}
