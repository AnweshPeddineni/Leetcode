class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            
        List<int[]> res = new ArrayList<>();
            
        for (int[] interval : intervals) {
            // here pay attention we are adding "interval" to res not newInterval
            if(newInterval == null || interval[1] < newInterval[0]){
                res.add(interval); 
            // below gets executed if newInterval falls in the front of final result
            } else if(interval[0] > newInterval[1]) {
                res.add(newInterval);
                res.add(interval);
                newInterval = null;
                
            } else{
                // important part of logic for merging this block executes when ever there are merging intervals, ex- 1) current interval is [3,5] and newInterval is [4,8]
            // 2) current interval is [6,7] and newInterval is [4,8]
            // 3) current interval is [8,10] and newInterval is [4,8]
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
            
        if (newInterval != null) res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }
}