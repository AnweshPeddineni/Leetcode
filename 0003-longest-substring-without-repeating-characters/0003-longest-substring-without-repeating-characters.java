class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int[] charMap = new int[128];
        
        int left = 0;
        int right = 0;

        int maxLength = 0;

        while(right < s.length()){
            charMap[s.charAt(right)]++;

            while(charMap[s.charAt(right)] > 1){
                charMap[s.charAt(left)]--;
                left++;
            }

            maxLength = Math.max(maxLength, right-left+1);

            right++;
        }

        return maxLength;
    }
}