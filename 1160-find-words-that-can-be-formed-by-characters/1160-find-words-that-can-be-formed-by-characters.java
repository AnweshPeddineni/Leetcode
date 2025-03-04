class Solution {
    public int countCharacters(String[] words, String chars) {

        int[] charsMap = new int[256];

        for(char c : chars.toCharArray()){
            charsMap[c]++;
        }

        int result = 0;

        for(String word : words){

            int[] wordMap = new int[256];
            for(char c : word.toCharArray()){
                wordMap[c]++;
            }

            if(checkMatch(charsMap, wordMap)){
                result += word.length();
            }

        }

        return result;
        
    }

    public boolean checkMatch(int[] charsMap, int[] wordMap){
        for (int i = 0; i < 256; i++) {
            if (wordMap[i] > charsMap[i]) {  // ✅ Only fail if wordMap exceeds charsMap
                return false;
            }
        }
        return true;
    }

}