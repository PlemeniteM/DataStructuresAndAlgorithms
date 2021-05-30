class Solution {
     public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length()==0||text2.length()==0)return 0;
        int n=text1.length();
        int m=text2.length();
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(text1.charAt(i)==text2.charAt(j)){
                   if(i>0&&j>0) dp[i][j]=1+dp[i-1][j-1];
                    else dp[i][j]=1;
                    }
                else{
                    if(i>0&&j>0)dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                    else if(i>0)dp[i][j]=dp[i-1][j];
                    else if(j>0)dp[i][j]=dp[i][j-1];
                } 
            }
        }
        return dp[n-1][m-1];
        
        // return helper(text1,text2,text1.length(),text2.length());
    }
    // int[][] dp=new int[1001][1001];
    // public int helper(String a,String b,int n,int m){
    //     if(n==0||m==0)return 0;
    //     if(dp[n-1][m-1]>0)return dp[n-1][m-1];
    //     if(a.charAt(n-1)==b.charAt(m-1))return dp[n-1][m-1]=1+helper(a,b,n-1,m-1);
    //     else  return dp[n-1][m-1]=Math.max(helper(a,b,n-1,m),helper(a,b,n,m-1));
    // }
}