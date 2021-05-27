class Solution {
    public static int coinChange(int[] coins, int amount) {
//          int[][] dp=new int[coins.length+1][amount+1];
//         for(int i=1;i<dp.length;i++){
//             dp[i][0]=0;
//         }
//         for(int j=0;j<dp[0].length;j++){
//             dp[0][j]=Integer.MAX_VALUE-1;
//         }
       
//         for(int j=1;j<dp[0].length;j++){
//             if(j%coins[0]!=0)dp[1][j]=Integer.MAX_VALUE-1;
//             else dp[1][j]=j/coins[0];
//         }
        
//         for(int i=2;i<dp.length;i++){
//             for(int j=1;j<dp[0].length;j++){
//                 if(coins[i-1]<=j)dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
//                 else dp[i][j]=dp[i-1][j];
//             }
//         }
//         return dp[coins.length][amount]!=Integer.MAX_VALUE-1?dp[coins.length][amount]:-1;
        
        if (coins == null || coins.length == 0 || amount <= 0)
            return 0;
        int[] minNumber = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            minNumber[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && minNumber[i - coins[j]] != Integer.MAX_VALUE)
                    minNumber[i] = Integer.min(minNumber[i], 1 + minNumber[i - coins[j]]);
            }
        }
        if (minNumber[amount] == Integer.MAX_VALUE)
            return -1;
        else
            return minNumber[amount];
    }
}