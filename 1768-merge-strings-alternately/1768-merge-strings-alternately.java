class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();

        int pOne = 0;
        int pTwo = 0;

        while(pOne < word1.length() && pTwo < word2.length()){
            sb.append(word1.charAt(pOne));
            pOne++;
            sb.append(word2.charAt(pTwo));
            pTwo++;
        }

        if(pOne == word1.length()){
            sb.append(word2.substring(pTwo));
        }
        if(pTwo == word2.length()){
            sb.append(word1.substring(pOne));
        }

        return sb.toString();
    }
}