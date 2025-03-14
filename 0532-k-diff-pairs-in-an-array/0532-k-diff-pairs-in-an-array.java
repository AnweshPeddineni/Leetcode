class Solution {
    public int findPairs(int[] nums, int k) {
        
        if(nums == null || nums.length==0){
            return 0;
        }
        int count = 0;

        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i],0)+1);
        }

        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            if((freqMap.containsKey(entry.getKey()+k) && k!=0) || (k==0 && entry.getValue()>1)){
                count++;
            }
        }
        return count;
    }
}