import java.util.HashMap;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return ""; // Edge case: Empty input
        }

        String result = "";
        HashMap<Integer, Character> strMap = new HashMap<>();
        int strIndex = 0;

        // Map characters of the first string
        for (char c : strs[0].toCharArray()) {
            strMap.put(strIndex, c);
            strIndex++;
        }

        int resLen = Integer.MAX_VALUE; // Start with a high value

        // Iterate over the strings to find the common prefix
        for (String str : strs) {
            int i = 0; // Index for current string
            while (i < str.length() && i < strMap.size() && strMap.get(i) == str.charAt(i)) {
                i++; // Characters match
            }
            resLen = Math.min(resLen, i); // Update the minimum prefix length

            // If no common prefix exists, return immediately
            if (resLen == 0) {
                return "";
            }
        }

        // Return the substring of the first string up to resLen
        return strs[0].substring(0, resLen);
    }
}
