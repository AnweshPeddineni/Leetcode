import java.util.*;

class Solution {
    public int maxNumberOfBalloons(String text) {
        // Array to store frequency of each character in 'a' to 'z'
        int[] charCount = new int[26];
        String balloon = "balloon";

        // Count occurrences of each character in the given text
        for (char c : text.toCharArray()) {
            charCount[c - 'a']++;
        }

        // Initialize the maximum number of "balloon" instances to a large number
        int maxBalloons = Integer.MAX_VALUE;

        // Calculate the minimum number of times we can extract "balloon"
        for (char c : balloon.toCharArray()) {
            int requiredCount = 1; // Default required count for 'b', 'a', 'n'
            if (c == 'l' || c == 'o') {
                requiredCount = 2; // 'l' and 'o' appear twice in "balloon"
            }
            // Update the maximum number of "balloon" instances
            maxBalloons = Math.min(maxBalloons, charCount[c - 'a'] / requiredCount);
        }

        return maxBalloons;
    }
}
