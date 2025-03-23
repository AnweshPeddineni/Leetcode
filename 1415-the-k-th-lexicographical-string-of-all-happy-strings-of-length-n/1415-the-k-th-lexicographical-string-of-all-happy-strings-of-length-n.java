class Solution {
    private int count = 0;     // Counter to track the number of happy strings found
    private String result = ""; // Stores the k-th happy string when found
    private final char[] chars = {'a', 'b', 'c'}; // Possible characters

    public String getHappyString(int n, int k) {
        backtrack(new StringBuilder(), n, k);
        return result; // Return the result (empty if k-th string doesn't exist)
    }

    // Backtracking function to generate happy strings
    private void backtrack(StringBuilder current, int n, int k) {
        // Base case: If the string reaches length n
        if (current.length() == n) {
            count++;
            if (count == k) {
                result = current.toString();  // Store the k-th string when found
            }
            return;
        }

        // Explore possible characters 'a', 'b', 'c'
        for (char c : chars) {
            // Skip the character if it's the same as the last added character
            if (current.length() == 0 || current.charAt(current.length() - 1) != c) {
                current.append(c);     // Choose the current character
                backtrack(current, n, k); // Explore further with recursion
                current.deleteCharAt(current.length() - 1); // Undo the choice (Backtrack)

                // Early exit for optimal performance
                if (!result.isEmpty()) return; // Stop recursion once k-th string is found
            }
        }
    }
}
