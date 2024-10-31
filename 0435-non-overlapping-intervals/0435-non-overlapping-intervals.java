class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b) -> (a[0]-b[0]));
        
        int remove = 0;
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] < end){
                remove++;
                
                // when there is an overlap always remove the interval that is larger among the two.
                end = Math.min(end, intervals[i][1]);
            }else{
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        
        return remove;
    }
}