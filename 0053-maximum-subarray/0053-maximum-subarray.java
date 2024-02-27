class Solution {
    public int maxSubArray(int[] nums) {      
        if(nums.length == 1) return nums[0];
        
        int max = Integer.MIN_VALUE;
        int sum = 0;
        
        for(int n: nums){
            // Add the current element to the running sum.
            sum += n;
            max = Math.max(max, sum);
 // If the running sum becomes negative, reset it to 0.
 // This is the greedy step, deciding to potentially start a new subarray from the next element.
            if(sum < 0){
                sum = 0;
            }
        }
        return max;
    }
}


