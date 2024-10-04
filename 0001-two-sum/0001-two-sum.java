class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int[] res = new int[2];
        
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], i);
        }
        
        for(int i=0; i<nums.length; i++){
            
            int pair = target-nums[i];
            if(map.containsKey(pair) && i != map.get(pair)){
                
                res[0] = i;
                res[1] = map.get(pair);
            }
        }
        
        return res;
    }
}