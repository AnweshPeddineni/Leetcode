class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        // Step 1: Create a map for characters in t
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Sliding window variables
        HashMap<Character, Integer> windowMap = new HashMap<>();
        int have = 0; // count of characters we have in the correct frequency
        int need = tMap.size(); // the number of unique characters in t we need
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;

        // Step 3: Expand the window by moving the right pointer
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            // Step 4: Check if the current character satisfies the tMap frequency
            if (tMap.containsKey(c) && windowMap.get(c).intValue() == tMap.get(c).intValue()) {
                have++;
            }

            // Step 5: Contract the window by moving the left pointer
            while (have == need) {
                // Update the minimum window size
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                // Move the left pointer and update the window map
                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                if (tMap.containsKey(leftChar) && windowMap.get(leftChar) < tMap.get(leftChar)) {
                    have--;
                }
                left++;
            }
        }

        // Step 6: Return the result
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}
