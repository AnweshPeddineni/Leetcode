class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums == null || nums.length < 3) return result;

    Arrays.sort(nums);
    int n = nums.length;

    for (int i = 0; i < n - 2; i++) {
        // **I will skip duplicate anchors to avoid duplicate triplets**
        if (i > 0 && nums[i] == nums[i - 1]) continue;

        // **Optional pruning: if the smallest anchor is > 0, no solution ahead**
        if (nums[i] > 0) break;

        int l = i + 1, r = n - 1;

        while (l < r) {
            int sum = nums[i] + nums[l] + nums[r];

            if (sum == 0) {
                // **I will add the triplet and then skip duplicates on both sides**
                result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                l++;
                r--;

                // **Skip left duplicates**
                while (l < r && nums[l] == nums[l - 1]) l++;
                // **Skip right duplicates**
                while (l < r && nums[r] == nums[r + 1]) r--;

            } else if (sum < 0) {
                // **I will increase sum by moving left pointer right**
                l++;
            } else {
                // **I will decrease sum by moving right pointer left**
                r--;
            }
        }
    }
    return result;
}

}