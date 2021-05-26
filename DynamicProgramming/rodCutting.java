class Solution{
    public int cutRod(int price[], int n) {
       
       
       int[]dp=new int[n+1];
       
       for(int i=0;i<n+1;i++){
           for(int j=0;j<price.length+1;j++){
               if(j==0||i==0)dp[j]=0;
               else{
                   if(i<=j){
                       dp[j]=Math.max(dp[j],dp[j-i]+price[i-1]);
                   }
               }
               
           }
       }
       return dp[n];
       
       
       
    }
}