class Solution {
    public String minWindow(String s, String t) {
        
        int[] tMap = new int[128];
        
        char[] sArr = s.toCharArray();
        
        
        for(char c : t.toCharArray()){
            tMap[c]++;
        }
        
        
        int minLength = Integer.MAX_VALUE;
        
        int sLength = s.length();
        
        int countAllCharInt = 0;
        
        String result = "";
        
        int left = 0;
        
        int right = 0;
        
        
        while(right < sLength){
            
            tMap[sArr[right]]--;
            
            if(tMap[sArr[right]] >= 0){
                countAllCharInt++;
            }
            
            while(countAllCharInt == t.length()){
                
                if(minLength > right-left+1){
                    minLength = right-left+1;
                    result = s.substring(left, right+1);
                }
                
                tMap[sArr[left]]++;
                
                if(tMap[sArr[left]] > 0){
                    countAllCharInt--;
                }
               
                left++;
            }
            
            right++;
            
        }
        
        return result;
        
    }
}