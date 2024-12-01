class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        
        int left = 0;
        
        int windowSum = 0;

        int result = 0;

        for(int i=0; i<k; i++){
            windowSum += arr[i];
        }

        if(windowSum/k >= threshold){
            result++;
        }

        for(int right = k; right < arr.length; right++){
            
            windowSum += arr[right];

            if(right-left+1 > k){
                windowSum -= arr[left];
                left++;
            }

            if(windowSum/k >= threshold){
            result++;
            }
        }

        return result;
    }
}