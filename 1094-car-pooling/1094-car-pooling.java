class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        Arrays.sort(trips, (a,b) -> (a[1]-b[1]));

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> (a[2]-b[2]));

        int passengerCount = 0;

        for(int[] trip : trips){

            while(!minHeap.isEmpty() && minHeap.peek()[2] <= trip[1]){
                  passengerCount -= minHeap.peek()[0];
                  minHeap.poll();
            }
            minHeap.offer(trip);

            passengerCount += trip[0];

            if(passengerCount > capacity){
                return false;
            }
        }

        return true;
    }
}