class Solution {
    public String reorganizeString(String s) {
        int n = s.length();

        // Frequency array for characters 'a' to 'z'
        int[] frequency = new int[26];
        for (char c : s.toCharArray()) {
            frequency[c - 'a']++;
        }

        // Find the character with maximum frequency
        int maxFreq = 0, maxCharIndex = 0;
        for (int i = 0; i < 26; i++) {
            if (frequency[i] > maxFreq) {
                maxFreq = frequency[i];
                maxCharIndex = i;
            }
        }

        // Impossible condition check
        if (maxFreq > (n + 1) / 2) return "";

        // Result array to fill in-place
        char[] result = new char[n];
        int idx = 0;

        // Fill the most frequent character first (at even indices)
        while (frequency[maxCharIndex] > 0) {
            result[idx] = (char) (maxCharIndex + 'a');
            idx += 2;  // Fill even indices first
            frequency[maxCharIndex]--;
        }

        // Fill remaining characters
        for (int i = 0; i < 26; i++) {
            while (frequency[i] > 0) {
                if (idx >= n) idx = 1;  // Switch to odd indices after filling even
                result[idx] = (char) (i + 'a');
                idx += 2;
                frequency[i]--;
            }
        }

        return new String(result);
    }
}
