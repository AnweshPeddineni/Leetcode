import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLength = 0;

        for (int num : nums) {
            if (set.contains(num)) {  // Only process if it's still in the set
                set.remove(num);  // Remove the number immediately
                int currLength = 1;
                int left = num - 1, right = num + 1;

                // Expand left and right while removing elements from the set
                while (set.contains(left)) {
                    set.remove(left);
                    currLength++;
                    left--;
                }
                
                while (set.contains(right)) {
                    set.remove(right);
                    currLength++;
                    right++;
                }

                maxLength = Math.max(maxLength, currLength);
            }
        }

        return maxLength;
    }
}
