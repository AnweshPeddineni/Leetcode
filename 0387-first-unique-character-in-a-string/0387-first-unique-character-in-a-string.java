class Solution {
    public int firstUniqChar(String s) {
        
        int[] sCharMap = new int[26];

        for(char c : s.toCharArray()){
            sCharMap[c-'a']++;
        }

        for(int i=0; i<s.length(); i++){
            char currChar = s.charAt(i);
            if(sCharMap[currChar-'a'] == 1){
                return i;
            }
        }

        return -1;
    }
}