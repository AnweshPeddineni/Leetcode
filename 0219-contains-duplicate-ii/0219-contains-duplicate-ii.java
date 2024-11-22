class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        if(k==0) return false;
        
        HashSet<Integer> set = new HashSet<>();
        
        int j=1;
        
        for(int i = 0; i < nums.length ; i++){
            
            set.add(nums[i]);
            
            while(Math.abs(j-i) <= k && j < nums.length){
                if(set.contains(nums[j])){
                    return true;
                }
                set.add(nums[j]);
                j++;
            }
            
            set.remove(nums[i]);
        }
        
        return false;
        
    }
}