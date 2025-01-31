class Solution {
    public int[] sortArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int min = nums[0];

        int max = nums[0];


        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);

            if(nums[i] > max){
                max = nums[i];
            }

            if(nums[i] < min){
                min = nums[i];
            }

        }

        int count = 0;

        for(int i=min; i<=max; i++){

            if(map.containsKey(i)){
                while(map.get(i) > 0){
                   nums[count] = i;
                   count++;
                   map.put(i, map.getOrDefault(i,0)-1);
                }
            }
        }

        return nums;


    }
}