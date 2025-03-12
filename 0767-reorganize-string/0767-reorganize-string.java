
class Solution {
    // Helper class to store character and its frequency
    class CharFrequency {
        char character;
        int frequency;

        CharFrequency(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
        }
    }

    public String reorganizeString(String s) {
        if (s == null || s.length() == 0) return "";

        // Step 1: Count frequencies using a fixed-size array (26 for lowercase English letters)
        int[] frequency = new int[26];
        for (char c : s.toCharArray()) {
            frequency[c - 'a']++;
        }

        // Step 2: Early termination check
        int maxFreq = 0;
        for (int freq : frequency) {
            if (freq > maxFreq) {
                maxFreq = freq;
            }
        }
        if (maxFreq > (s.length() + 1) / 2) {
            return "";
        }

        // Step 3: Initialize max heap based on frequencies
        PriorityQueue<CharFrequency> maxHeap = new PriorityQueue<>(
            (a, b) -> b.frequency - a.frequency // Descending order
        );

        for (int i = 0; i < 26; i++) {
            if (frequency[i] > 0) {
                char currentChar = (char) (i + 'a');
                maxHeap.offer(new CharFrequency(currentChar, frequency[i]));
            }
        }

        // Step 4: Reorganize the string
        StringBuilder result = new StringBuilder();
        CharFrequency prev = null; // To store the previously used character

        while (!maxHeap.isEmpty()) {
            // Poll the character with the highest frequency
            CharFrequency current = maxHeap.poll();
            result.append(current.character);

            // Decrement the frequency of the current character
            current.frequency--;

            // If there's a previously used character with remaining frequency, reinsert it into the heap
            if (prev != null && prev.frequency > 0) {
                maxHeap.offer(prev);
            }

            // Set the current character as previous for the next iteration
            prev = current;
        }

        // Step 5: Validate the result
        return result.length() == s.length() ? result.toString() : "";
    }
}
