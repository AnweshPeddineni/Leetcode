public class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // Sort the intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Priority Queue to store the end times of meetings. The meeting that ends earliest is at the top.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        
        // Add the first meeting's end time to the queue
        minHeap.add(intervals[0][1]);

        // Iterate over the rest of the intervals
        for (int i = 1; i < intervals.length; i++) {
            // If the current meeting starts after or exactly when the earliest meeting ends, they can use the same room
            if (intervals[i][0] >= minHeap.peek()) {
                minHeap.poll(); // Remove the earliest ending meeting
            }
            
            // Add the current meeting's end time to the queue
            minHeap.add(intervals[i][1]);
        }

        // The size of the queue is the number of rooms needed
        return minHeap.size();
    }
}