class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s.length() == 0 || s == null) return 0;
        
        int n = s.length();
        int l = 0;
        int r = 0;
        int maxLen = 0;
        
        int[] cMap = new int[128];
        
        while(r<n){
            char cR = s.charAt(r);
            
            cMap[cR]++;
            
            while(cMap[cR] > 1){
                char cL = s.charAt(l);
                cMap[cL]--;
                l++;
            }
            
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        
        return maxLen;
    }
}