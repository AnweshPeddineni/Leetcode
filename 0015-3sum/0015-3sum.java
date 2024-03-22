class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        
        for(int i=0; i<nums.length-2; i++){
             int lo = i+1;
             int hi = nums.length-1;
            while(lo < hi){
                int sum = nums[i] + nums[hi] + nums[lo];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[hi], nums[lo]));
                    lo++;
                    hi--;
                }else if(sum < 0){
                    lo++;
                }else{
                    hi--;
                }
            }
        }
        
        return new ArrayList<>(res);
    }
}