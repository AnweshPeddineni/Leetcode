import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";  // **If `t` is longer, return empty string**

        // **Frequency maps to track character counts**
        HashMap<Character, Integer> targetCount = new HashMap<>();
        HashMap<Character, Integer> windowCount = new HashMap<>();

        // **Populate targetCount with characters from `t`**
        for (char c : t.toCharArray()) {
            targetCount.put(c, targetCount.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int matchedCharacters = 0;  // **Count of characters in `s` matching `t`**
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;  // **Start index of the minimum window**

        // **Expand the window by moving `right`**
        while (right < s.length()) {
            char c = s.charAt(right);
            windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);

            if (targetCount.containsKey(c) && windowCount.get(c).intValue() == targetCount.get(c).intValue()) {
                matchedCharacters++;  // **Character `c` fully matches its required count**
            }

            // **Contract the window if all characters in `t` are matched**
            while (matchedCharacters == targetCount.size()) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;  // **Update minLength**
                    startIndex = left;  // **Update the start index of the minimum window**
                }

                // **Remove the leftmost character and move `left`**
                char leftChar = s.charAt(left);
                windowCount.put(leftChar, windowCount.get(leftChar) - 1);
                if (targetCount.containsKey(leftChar) && windowCount.get(leftChar) < targetCount.get(leftChar)) {
                    matchedCharacters--;  // **Character `leftChar` is no longer fully matched**
                }
                left++;
            }

            right++;
        }

        // **Return the minimum window substring if found**
        return minLength == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLength);
    }
}
