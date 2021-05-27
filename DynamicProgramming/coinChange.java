class Solution {
    public int change(int amount, int[] coins) {
        int[] dp=new int[amount+1];
        for(int i=1;i<coins.length+1;i++){
            for(int j=0;j<dp.length;j++){
                if(j==0)dp[j]=1;
                else if(coins[i-1]<=j)dp[j]=dp[j]+dp[j-coins[i-1]];
            }
        }
        return dp[amount];
    }
}