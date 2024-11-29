class Solution {
    public int maxFrequency(int[] nums, int k) {
        int left = 0;
        int right = 0;

        Arrays.sort(nums);

        long windowSum = 0;
        int maxFrequency = 0;

        while(right < nums.length){
           
           windowSum = windowSum+nums[right];

           while(nums[right]*(right-left+1L) - windowSum > k){
            windowSum = windowSum-nums[left];
            left++;
           }
        
           maxFrequency = Math.max(maxFrequency, right-left+1);

           right++; 
        }

        return maxFrequency;
    }
}