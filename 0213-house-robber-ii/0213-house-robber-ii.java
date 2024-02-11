class Solution {
    public int rob(int[] nums) {
        if(nums.length < 2){
            return nums[0];
        }
        
        int[] skipLast = new int[nums.length-1];
        int[] skipFirst = new int[nums.length-1];
        
        for(int i=0; i<nums.length-1; i++){
            skipLast[i] = nums[i];
            skipFirst[i] = nums[i+1];    
        }
        
        int sl = robHelper(skipLast);
        int sf = robHelper(skipFirst);
        
        return Math.max(sl, sf);
    }
    
    private int robHelper(int[] cut){
        if(cut.length < 2){
            return cut[0];
        }
        
        int[] dp = new int[cut.length];
        
        dp[0] =  cut[0];
        dp[1] = Math.max(dp[0], cut[1]);
        
        for(int i=2; i<cut.length; i++){
            dp[i] = Math.max((dp[i-2]+cut[i]), dp[i-1]);
        }
        
        return dp[cut.length-1];
        
    }
}