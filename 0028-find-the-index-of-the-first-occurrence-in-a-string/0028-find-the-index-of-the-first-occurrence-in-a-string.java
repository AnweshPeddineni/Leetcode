class Solution {
    public int strStr(String haystack, String needle) {

        if (needle.length() > haystack.length()) {
            return -1;
        }

        int i = 0;

        while (i <= haystack.length() - needle.length()) { // ✅ Ensure no overflow
            int j = 0;
            int start = i;

            while (j < needle.length() && haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;

                if (j == needle.length()) { // ✅ Return `start` when fully matched
                    return start;
                }
            }

            // Reset `i` to start + 1 to not skip valid matches
            i = start + 1;
        }

        return -1; // ✅ If no match is found
    }
}
