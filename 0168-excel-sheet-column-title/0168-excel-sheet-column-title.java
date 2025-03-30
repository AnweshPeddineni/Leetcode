class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        // Keep processing until columnNumber becomes 0
        while (columnNumber > 0) {
            columnNumber--;  // Convert to 0-based index (A -> 0, B -> 1, ..., Z -> 25)

            // Get the character to append (0 maps to 'A', 25 maps to 'Z')
            int remainder = columnNumber % 26;
            char letter = (char) (remainder + 'A');

            result.append(letter);  // Add the character to the result

            columnNumber = columnNumber / 26;  // Move to the next "digit"
        }

        // Since we built the string in reverse (from least significant to most), reverse it
        return result.reverse().toString();
    }
}
