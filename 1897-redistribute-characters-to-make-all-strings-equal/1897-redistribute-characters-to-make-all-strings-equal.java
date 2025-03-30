class Solution {
    public boolean makeEqual(String[] words) {
        // Step 1: Create a frequency array to count each character
        int[] freq = new int[26];  // 26 letters in the alphabet

        // Step 2: Count frequencies of each character in all words
        for (String word : words) {
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;  // Map 'a' to 0, 'b' to 1, ..., 'z' to 25
            }
        }

        int n = words.length;

        // Step 3: Check if every character count is divisible by number of words
        for (int count : freq) {
            if (count % n != 0) {
                return false; // If not divisible, cannot distribute evenly
            }
        }

        return true; // All characters can be evenly distributed
    }
}
