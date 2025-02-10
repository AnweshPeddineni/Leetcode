
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0])); // ✅ Sort intervals by start time

        ArrayList<int[]> result = new ArrayList<>();

        int i = 0;
        while (i < intervals.length) {  // ✅ Iterate through all intervals
            int start = intervals[i][0];
            int end = intervals[i][1];

            // ✅ Merge overlapping intervals
            while (i < intervals.length - 1 && end >= intervals[i + 1][0]) {
                end = Math.max(end, intervals[i + 1][1]); // Extend the merged interval
                i++; // Move to next interval
            }

            // ✅ Store the merged interval
            result.add(new int[]{start, end});
            i++; // Move to next interval
        }

        return result.toArray(new int[result.size()][2]); // ✅ Convert list to array
    }
}
