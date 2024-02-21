class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // dp[i] indicates whether the substring s[0...i] can be segmented into words from the dictionary.
        boolean[] dp = new boolean[s.length()];
        
        // Iterate through each character of the string s.
        for (int i = 0; i < s.length(); i++) {
            // Try to match each word in the dictionary against the substring ending at i.
            for (String word : wordDict) {
                // Skip if the current word is longer than the substring ending at i.
                if (i < word.length() - 1) {
                    continue;
                }
                
                // Two cases where a word can end at i:
                // 1. i matches the end of the word and the beginning of the string matches the word.
                // 2. The substring ending right before the start of this word can be segmented,
                //    and the substring from the start of this word to i matches the word.
                if (i == word.length() - 1 || dp[i - word.length()]) {
                    // Check if the substring matches the word.
                    if (s.substring(i - word.length() + 1, i + 1).equals(word)) {
                        dp[i] = true; // Mark the end of this word as a valid segmentation point.
                        break; // No need to check further words if one match is found.
                    }
                }
            }
        }
        
        // The last entry in dp indicates whether the whole string can be segmented.
        return dp[s.length() - 1];
    }
}
