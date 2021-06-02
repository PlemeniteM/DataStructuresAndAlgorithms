class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        // int[][]dp=new int[nums1.length+1][nums2.length+1];
        // int max=Integer.MIN_VALUE;
        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp[0].length;j++){
        //         if(i==0||j==0)dp[i][j]=0;
        //         else if(nums1[i-1]==nums2[j-1]){
        //             dp[i][j]=dp[i-1][j-1]+1;
        //         }
        //         else{
        //             dp[i][j]=0;
        //         }
        //         max=Math.max(max,dp[i][j]);
        //     }
        // }
        // return max;
        int[] dp=new int[nums2.length+1];
        dp[0]=0;
        int max=0;
        for(int i=0;i<nums1.length;i++){
            for(int j=nums2.length;j>0;j--){
                if(nums1[i]==nums2[j-1])dp[j]=1+dp[j-1];
                else dp[j]=0;
                max=Math.max(dp[j],max);
                
            }
         
        }
        return max;
    }
}