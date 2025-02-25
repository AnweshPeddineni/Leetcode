import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int i = 0;

        // ✅ Step 1: Cycle Sort (Place numbers in their correct index)
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            
            // ✅ Swap only if the number is not at its correct position and is unique
            if (nums[i] != nums[correctIndex]) {
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++;  // ✅ Move to the next index only when it's already correct
            }
        }

        // ✅ Step 2: Find Missing Numbers
        i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                result.add(i + 1); // ✅ Missing number is `i + 1`
            }
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(solution.findDisappearedNumbers(nums)); // Output: [5,6]
    }
}
