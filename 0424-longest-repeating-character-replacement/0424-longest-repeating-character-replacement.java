class Solution {
    public int characterReplacement(String s, int k) {
        
        int l = 0;
        int r = 0;
        
        int maxCount = 0;
        int maxLen = 0;
        
       int[] cMap = new int[26];
        
        while(r<s.length()){
            
            char rightChar = s.charAt(r);
            cMap[rightChar - 'A']++;
            maxCount = Math.max(maxCount, cMap[rightChar - 'A']);
            
            while(r-l+1 - maxCount > k){
                char leftChar = s.charAt(l);
                cMap[leftChar - 'A']--;
                l++;
            }
            
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        
        return maxLen;
        
        
    }
}