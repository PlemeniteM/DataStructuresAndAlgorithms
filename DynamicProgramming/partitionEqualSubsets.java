class Solution {
    public boolean canPartition(int[] nums) {
        int[] arr=nums;
        if(nums==null||nums.length<=1)return false;
        int arrsum=0;
        for(int i:nums){
            arrsum+=i;
        }
        if(arrsum%2==1)return false;
        int tar=arrsum/2;
        boolean[][] dp=new boolean[arr.length+1][tar+1];
      
      for(int i=0;i<dp.length;i++){
          for(int j=0;j<dp[0].length;j++){
              if(j==0)dp[i][j]=true;
              else if(i==0)dp[i][j]=false;
              
              else if(arr[i-1]>j)dp[i][j]=dp[i-1][j];
              else dp[i][j]=dp[i-1][j]||dp[i-1][j-arr[i-1]];
          }
      }
        
        
        return dp[nums.length][tar];
    }
    
}