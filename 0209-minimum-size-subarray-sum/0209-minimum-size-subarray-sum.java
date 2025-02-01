class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int left = 0;
        int right = 0;

        int minSize = Integer.MAX_VALUE;
        int currentSize = 0;
        int windowSum = 0;

        while(right < nums.length){

            windowSum += nums[right];

            while(windowSum >= target && left <= right){

                currentSize = right-left+1;
                minSize = Math.min(currentSize, minSize);

                windowSum -= nums[left];
                left++;
            }

            // if(windowSum >= target){
                
            // }

            right++; 
        }

        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }
}