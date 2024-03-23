class Solution {
    public int characterReplacement(String s, int k) {
        
        
        int l = 0;
        int r = 0;
        
        int maxCount = 0;
        int maxLen = 0;
        
        HashMap<Character, Integer> freqMap = new HashMap<>();
        
        while(r<s.length()){
            
            char rightChar = s.charAt(r);
            freqMap.put(rightChar, freqMap.getOrDefault(rightChar,0)+1);
            maxCount = Math.max(freqMap.get(rightChar), maxCount);
            
            while(r - l + 1 - maxCount > k){
                char leftChar = s.charAt(l);
                freqMap.put(leftChar, freqMap.get(leftChar)-1);
                l++;
                
                maxCount = Collections.max(freqMap.values());
            }
            
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        
        return maxLen;
        
        
    }
}