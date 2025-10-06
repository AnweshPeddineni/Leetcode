class Solution {
    public boolean checkInclusion(String s1, String s2) {

        // If s1 is longer than s2, s2 cannot contain a permutation of s1
        if (s1.length() > s2.length()) {
            return false;
        }

        // s1Map stores the frequency count of characters in s1
        int[] s1Map = new int[26];
        for (char ch : s1.toCharArray()) {
            s1Map[ch - 'a']++;
        }

        // windowMap stores the frequency count of characters in the current sliding window of s2
        int[] windowMap = new int[26];
        
        int l = 0; // Left pointer of the sliding window
        
        // Iterate with the right pointer 'r' through s2
        for (int r = 0; r < s2.length(); r++) {
            // Expand the window: Add the current character s2.charAt(r) to windowMap
            windowMap[s2.charAt(r) - 'a']++;

            // Shrink the window from the left if its size exceeds s1.length()
            // This ensures our sliding window always maintains a size of at most s1.length()
            while (r - l + 1 > s1.length()) {
                windowMap[s2.charAt(l) - 'a']--; // Remove the character at the left pointer
                l++; // Move the left pointer to the right
            }

            // Check for a permutation only when the window size matches s1.length()
            if (r - l + 1 == s1.length()) {
                // If the frequency maps match, we found a permutation
                if (Arrays.equals(s1Map, windowMap)) {
                    return true;
                }
            }
        }

        // If no permutation is found after checking all possible windows
        return false;
    }
}