class Solution {

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp=new Integer[m][n][maxMove+1];
        return helper(m,n,startRow,startColumn,0,maxMove);
    }

    Integer[][][] dp;
    int mod = 1000000007;

    public int helper(int m,int n,int i,int j,int mov,int max){
         if(i<0||j<0||i>=m||j>=n)return 1;

         if(mov>=max)return 0;

         if(dp[i][j][mov]!=null)return dp[i][j][mov];

         int count=0;

         count=count%mod+helper(m,n,i-1,j,mov+1,max)%mod;
         count=count%mod+helper(m,n,i+1,j,mov+1,max)%mod;
         count=count%mod+helper(m,n,i,j+1,mov+1,max)%mod;
         count=count%mod+helper(m,n,i,j-1,mov+1,max)%mod;
         
         dp[i][j][mov]=count%mod;

        return dp[i][j][mov];
    }
}