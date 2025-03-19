class Solution {
    public int subarraySum(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();

        int result = 0;
        
        int prefSum = 0;

        map.put(0,1);

        for(int i=0; i<nums.length; i++){
            prefSum += nums[i];  

            if(map.containsKey(prefSum-k)){
              result += map.get(prefSum-k);
            }

             map.put(prefSum, map.getOrDefault(prefSum,0)+1);
        }

        return result;
    }
}