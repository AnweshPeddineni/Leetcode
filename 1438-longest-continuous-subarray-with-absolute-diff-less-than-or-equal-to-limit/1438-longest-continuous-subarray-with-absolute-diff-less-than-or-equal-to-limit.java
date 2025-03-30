class Solution {
    public int longestSubarray(int[] nums, int limit) {
        
        int left = 0;
        int right = 0;

        int max = 0;
        int min = 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->(a-b));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->(b-a));

        int subArraySize = 0;

        while(right < nums.length){
           
           minHeap.offer(nums[right]);
           maxHeap.offer(nums[right]);

           max = maxHeap.peek();
           min = minHeap.peek();

           while(max - min > limit){
              if(minHeap.peek() == nums[left]){
                 left++;
                 minHeap.poll();
                 min = minHeap.peek();
              }

              if(minHeap.peek() == nums[left]){
                left++;
                maxHeap.poll();
                max = maxHeap.peek();
              }
           }

           subArraySize = Math.max(subArraySize, right-left+1);
           right++;
        }

        return subArraySize;
    }
}