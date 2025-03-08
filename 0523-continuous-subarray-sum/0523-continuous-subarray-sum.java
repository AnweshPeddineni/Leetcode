class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();

        int currentSum = 0;

        for(int i=0; i<nums.length; i++){
            currentSum += nums[i];

            set.add(currentSum);

            if(set.contains(currentSum-k)){
                return true;
            }
        }

        return false;
    }
}