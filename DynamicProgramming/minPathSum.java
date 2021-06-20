class Solution {

    public int minPathSum(int[][] grid) {
        dp=new int[grid.length+1][grid[0].length+1];
        return helper(grid,0,0,0);
    }

    int[][] dp;

    public int helper(int[][] grid,int i,int j,int score){
        //If you reach last cell of grid
        if(i==grid.length-1&&j==grid[0].length-1){
            return dp[i][j]=score+grid[i][j];
        }
        if(dp[i][j]!=0)return dp[i][j];

        //If you are in last columnn then only possible move is down
        if(j==grid[0].length-1&&i!=grid.length-1) return dp[i][j]=grid[i][j]+helper(grid,i+1,j,score);

        //If you are in last row then only possible move is right
        if(i==grid.length-1&&j!=grid[0].length-1) return dp[i][j]=grid[i][j]+helper(grid,i,j+1,score);
        
        return dp[i][j]=grid[i][j]+Math.min(helper(grid,i,j+1,score),helper(grid,i+1,j,score));
    }
}