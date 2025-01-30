class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->(a-b));

        for(int num : nums){
            minHeap.add(num);
        }

        for(int i=0; i<nums.length; i++){
            nums[i] = minHeap.poll();
        }

        return nums;
    }
}