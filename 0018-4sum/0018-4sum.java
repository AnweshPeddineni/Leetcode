

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums); // ✅ Sort array for two-pointer technique
        Set<List<Integer>> result = new HashSet<>(); // ✅ Use HashSet to store unique quadruplets

        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                int k = j + 1, l = n - 1; // ✅ Two-pointer setup

                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++; // Move left pointer
                        l--; // Move right pointer
                    } else if (sum < target) {
                        k++; // Need a larger sum
                    } else {
                        l--; // Need a smaller sum
                    }
                }
            }
        }

        // ✅ Convert Set to List before returning
        return new ArrayList<>(result);
    }
}
