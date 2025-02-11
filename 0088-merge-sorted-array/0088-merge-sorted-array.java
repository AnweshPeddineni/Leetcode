class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int i=0;
        int j=0;

        while(i<m && j<n){
            if(nums1[i] > nums2[j]){
                shiftOne(nums1, i, m);
                nums1[i] = nums2[j];
                j++;
                m++;
            }
            
            i++;
        
        }
        
        
        while(j<n){
            nums1[i] = nums2[j];
            i++;
            j++;
        }
  

    }

    public void shiftOne(int[] nums, int start, int m){
      
       for(int i=m-1; i>=start; i--){
          nums[i+1] = nums[i];
       }
      
    }
}