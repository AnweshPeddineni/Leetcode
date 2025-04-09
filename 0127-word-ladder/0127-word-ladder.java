
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Step 1: Convert wordList to a set for O(1) lookup
        Set<String> wordSet = new HashSet<>(wordList);
        
        // Step 2: If endWord is not in the list, no transformation is possible
        if (!wordSet.contains(endWord)) return 0;

        // Step 3: Standard BFS setup
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int level = 1;  // Begin with level 1 (beginWord itself)

        while (!queue.isEmpty()) {
            int size = queue.size();

            // Step 4: For all words at the current BFS level
            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                // Try changing each character (a-z) in the current word
                for (int j = 0; j < word.length(); j++) {
                    char[] chars = word.toCharArray();

                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        String nextWord = new String(chars);

                        // If this transformation leads to the endWord, we’re done
                        if (nextWord.equals(endWord)) return level + 1;

                        // If it's in the word set, add to queue and remove from set (visited)
                        if (wordSet.contains(nextWord)) {
                            queue.offer(nextWord);
                            wordSet.remove(nextWord);
                        }
                    }
                }
            }

            level++;  // Move to next level
        }

        return 0;  // If we reach here, no transformation path exists
    }
}
