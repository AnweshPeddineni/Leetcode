class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        int maxSeq = 0;   

        for(int num : set){

          if(!set.contains(num-1)){
            int curr = num;
            int currSeq = 1;
            while(set.contains(curr+1)){
              currSeq += 1;
              curr += 1;
            }
            maxSeq = Math.max(currSeq, maxSeq);      
          }

          
        }

        return maxSeq;
    }
}