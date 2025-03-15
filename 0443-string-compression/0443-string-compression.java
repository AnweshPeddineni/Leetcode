class Solution {
    public int compress(char[] chars) {
        int i = 0;
        int j = 0;

        while(j<chars.length && i<chars.length){
            char currChar = chars[j];
            int count = 0;

            while(j<chars.length && chars[j] == currChar){
               count++;
               j++;
            }

            chars[i++] = currChar;

            if(count > 1){
               for(char c : String.valueOf(count).toCharArray()){
                 chars[i++] = c;
               }
            }
            
        }

        return i;
    }
}