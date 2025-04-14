import java.util.*;

class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        // Step 1: Store all words in a set for O(1) lookup
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));

        List<String> concatenatedWords = new ArrayList<>();
        Map<String, Boolean> memo = new HashMap<>();  // Memoization map

        // Step 2: For each word, check if it's a valid concatenated word
        for (String word : words) {
            if (word.equals("")) continue; // Skip empty words
            if (checkConcatenate(word, wordSet, memo)) {
                concatenatedWords.add(word);
            }
        }

        return concatenatedWords;
    }

    // Recursive function to check if a word can be formed by concatenating other words
    private boolean checkConcatenate(String word, Set<String> wordSet, Map<String, Boolean> memo) {
        if (memo.containsKey(word)) {
            return memo.get(word);  // Return already computed result
        }

        // Try every split point in the word
        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);

            // Check if prefix is a valid word, and suffix is either a valid word or can be broken down recursively
            if (wordSet.contains(prefix)
                && (wordSet.contains(suffix) || checkConcatenate(suffix, wordSet, memo))) {
                memo.put(word, true);  // Cache result
                return true;
            }
        }

        memo.put(word, false);  // Cache failure
        return false;
    }
}
