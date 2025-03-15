class Solution {
    public int compress(char[] chars) {
        int j = 0;  // Write pointer
        int i = 0;  // Read pointer

        while (i < chars.length) {
            char currentChar = chars[i];  // Track current character
            int count = 0;                // Track consecutive occurrences

            // **Count consecutive characters**
            while (i < chars.length && chars[i] == currentChar) {
                count++;
                i++;
            }

            // **Write the character**
            chars[j++] = currentChar;

            // **Write the count if greater than 1**
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[j++] = c;
                }
            }
        }

        return j;  // Return the new length
    }
}
