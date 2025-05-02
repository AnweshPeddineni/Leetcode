class Solution {
    public int numberOfSubstrings(String s) {
        int[] count = new int[3];  // To count 'a', 'b', 'c'
        int left = 0, result = 0;

        for (int right = 0; right < s.length(); right++) {
            // Update count for current character
            count[s.charAt(right) - 'a']++;

            // While window is valid (contains a, b, c), move left to shrink
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                // If window [left...right] is valid, then all substrings
                // from left to end are also valid
                result += s.length() - right;

                // Shrink the window from left
                count[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return result;
    }
}
