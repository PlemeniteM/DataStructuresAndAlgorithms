class Solution {

    //sliding window
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) prod /= nums[left++];
            ans += right - left + 1;
        }
        return ans;
    }
    
    //brute force
    public int numSubarrayProductLessThanK(int[] nums, int k) {
       int count=0;
       
       for(int i=0;i<nums.length;i++){
           if(nums[i]>=k)continue;
           int prod=1;
           count++;
           prod*=nums[i];
           for(int j=i+1;j<nums.length;j++){
               prod*=nums[j];
               if(prod<k)count++;
               else break;
           }
           
       }
       return count;
    }
}