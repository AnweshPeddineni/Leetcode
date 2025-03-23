class Solution {
    public String longestPalindrome(String s) {
        
        int i = 0;
        int j = 0;

        String result = "";

        while (i < s.length() && j < s.length()) {

            // Check if s[i...j] is a palindrome
            if (checkPalindrome(s, i, j)) {
                String currResult = s.substring(i, j + 1);

                // Update result if we found a longer palindrome
                if (currResult.length() > result.length()) {
                    result = currResult;
                }
            }

            // Move the `j` pointer to explore longer substrings
            j++;

            // If `j` reaches the end and no valid palindrome is found,
            // reset `i` to the next index and start over.
            if (j == s.length()) {
                i++;
                j = i; // Start j again from i
            }
        }

        return result;
    }

    // Palindrome checking function
    public boolean checkPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false; // Found mismatch, not a palindrome
            }
            i++;
            j--;
        }
        return true; // All characters matched, it's a palindrome
    }
}
