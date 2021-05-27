class Solution {
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        
        dp=new int[coins.length+1][amount+1];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        int val=solve(coins,amount,coins.length);
        
        return  val==Integer.MAX_VALUE-1?-1:val ;
    }
   public int solve(int[]arr,int  w,int  n) {
		if(n == 0) {
            return dp[n][w] = Integer.MAX_VALUE-1;
		}
		if(w == 0 ) {
            return dp[n][w] = 0;
		}

		if(dp[n][w] != -1) {
            return dp[n][w];
        }
		if(arr[n-1] > w) {
            return dp[n][w] = solve(arr, w, n-1);
		}
        return dp[n][w] = Math.min(1 + solve(arr, w - arr[n-1], n),solve(arr, w, n-1));
       }

}