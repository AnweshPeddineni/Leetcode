class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        HashMap<Character, Integer> s1Map = new HashMap<>();

        HashMap<Character, Integer> s2WindowMap = new HashMap<>();


        for(int i=0; i<s1.length(); i++){
            s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i),0)+1);
        }


        int left = 0;
        int right = 0;

        while(right < s2.length()){
          
            s2WindowMap.put(s2.charAt(right), s2WindowMap.getOrDefault(s2.charAt(right),0)+1);
        
            while(right - left + 1 > s1.length()){
                char leftChar = s2.charAt(left);
                s2WindowMap.put(leftChar, s2WindowMap.get(leftChar) - 1);
                if (s2WindowMap.get(leftChar) == 0) {
                    s2WindowMap.remove(leftChar);  // Remove entry if count reaches 0
                }
                left++;
            }

            if(s1Map.equals(s2WindowMap)){
                return true;
            }

            right++;
        }

        return false;
    }
}