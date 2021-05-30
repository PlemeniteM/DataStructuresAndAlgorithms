class Solution {
     public int numSquares(int n) {
         if (n == 0) return 0;
         if (isSquare(n)) return 1;
         if (isSumOfFourIntegers(n)) return 4;
         if (isSumOfSquares(n)) return 2;
         return 3;
     }

     private boolean isSquare(int n) {
         int squareRoot = squareRoot(n);
         return squareRoot * squareRoot == n;
     }

     private int squareRoot(int n) {
         return (int) Math.sqrt(n);
     }

    // Values of the form 4^n(8k+7) are the sum of 4 integers.
     private boolean isSumOfFourIntegers(int n) {
         while (n % 4 == 0) n /= 4;
         return n % 8 == 7;
     }

    // O(sqrt(n))
     private boolean isSumOfSquares(int n) {
         for (int i = 1; i <= squareRoot(n); i++) {
             if (isSquare(n - (i * i))) return true;
         }

         return false;
     }







    // public int numSquares(int n) {
    //     int num=1;
    //     for(int i=num;i<=n;i++){
    //         if(Math.ceil((double)Math.sqrt(i))==Math.floor((double)Math.sqrt(i))){
    //             num=i;
    //         }
    //     }

    //     int[][] dp=new int[(int)Math.sqrt(num)+1][n+1];
    //     for(int i=1;i<n+1;i++){
    //         dp[1][i]=i;
    //     }
    //     for(int i=2;i<(int)Math.sqrt(num)+1;i++){
    //         for(int j=0;j<n+1;j++){
                
    //              if(i*i>j)dp[i][j]=dp[i-1][j];
    //             else if(i*i<=j)dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-(i*i)]);
                
    //         }
           
    //     }
        
    //     return dp[(int)Math.sqrt(num)][n];
    // }
    
}