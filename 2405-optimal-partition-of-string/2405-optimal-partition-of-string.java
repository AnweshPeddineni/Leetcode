class Solution {
    public int partitionString(String s) {


        int[] subMap = new int[256];

        int result = 0;
        
        int i=0;

        for(int j=0; j<s.length(); j++){
            char jChar = s.charAt(j);
            subMap[jChar]++;

            if(subMap[jChar] > 1){
                result++;
                while(i<j){
                    char iChar = s.charAt(i);
                    subMap[iChar]--;
                    i++;
                }
            }
        }

        return result+1;
        
    }
}


//     l
//    "abacaba"
//       r