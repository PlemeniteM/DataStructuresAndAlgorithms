class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // int[] dp=new int[cost.length];
        // dp[cost.length-1]=cost[cost.length-1];
        // for(int i=cost.length-2;i>=0;i--){
        //     if(i==cost.length-2)dp[i]=cost[i];
        //     else if(i==0)dp[i]=cost[i]+dp[i+2];
        //     else dp[i]=cost[i]+Math.min(dp[i+1],dp[i+2]);
        // }
        // return Math.min(dp[0],dp[1]);
        
        //Space optimized
        
        int fst=cost[0];
        int sst=cost[1];
        if(cost.length==2)return Math.min(fst,sst);
        for(int i=2;i<cost.length;i++){
            int curr=cost[i]+Math.min(fst,sst);
            fst=sst;
            sst=curr;
        }
        return Math.min(fst,sst);
    }
}