class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        
         Map<Character,Integer> map = new HashMap<>();

         int maxLength = -1;

         for(int i=s.length()-1; i>=0; i--){
            if(!map.containsKey(s.charAt(i))){
               map.put(s.charAt(i),i);
            } 
         }

        for(int i=0; i<s.length(); i++){
           char curr = s.charAt(i);
           if(map.containsKey(curr)){
              maxLength = Math.max(maxLength, map.get(curr)-i-1);
           }
        }

        return maxLength;
    }
}

//             i
// Input: s = "abcaxdzca"
//                j