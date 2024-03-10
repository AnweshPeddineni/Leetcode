class Solution {
    public int[][] merge(int[][] intervals) {
        
        ArrayList<int[]> ans = new ArrayList<>();
        
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        
        ans.add(intervals[0]);
        
        for(int i=1; i<intervals.length; i++){
            int curStart = intervals[i][0];
            int prevEnd = ans.get(ans.size()-1)[1];
            
            // important logic
            if(curStart <= prevEnd){
                ans.get(ans.size()-1)[1] = Math.max(prevEnd, intervals[i][1]);
            }else{
                ans.add(intervals[i]);
            }
        }
        int[][] res = new int[ans.size()][2];
        ans.toArray(res);
        return res;
        
        
    }
}

// The time complexity of this algorithm is O(nlogn + n), which simplifies to O(nlogn).
// The space complexity of this algorithm is O(n)
