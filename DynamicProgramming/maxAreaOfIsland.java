class Solution {
    // public int maxAreaOfIsland(int[][] grid) {
    //     int max_area = 0;
    //     for(int i = 0; i < grid.length; i++)
    //         for(int j = 0; j < grid[0].length; j++)
    //             if(grid[i][j] == 1)max_area = Math.max(max_area, AreaOfIsland(grid, i, j));
    //     return max_area;
    // }
    
    // public int AreaOfIsland(int[][] grid, int i, int j){
    //     if( i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1){
    //         grid[i][j] = 0;
    //         return 1 + AreaOfIsland(grid, i+1, j) + AreaOfIsland(grid, i-1, j) + AreaOfIsland(grid, i, j-1) + AreaOfIsland(grid, i, j+1);
    //     }
    //     return 0;
    // }
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        int count=Integer.MIN_VALUE;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(visited[i][j]!=true){
                    helper(grid,i,j,visited);
                    count=Math.max(curr,count);
                    curr=0;
                }
            }
        }
        return count;
    }
    int curr=0;
    private int helper(int[][]grid,int i,int j,boolean[][] vis){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]==0||vis[i][j]){
            return 0;
        }
        vis[i][j]=true;
        if(grid[i][j]==1)curr+=1;
        helper(grid,i+1,j,vis);
        helper(grid,i-1,j,vis);
        helper(grid,i,j+1,vis);
        helper(grid,i,j-1,vis);
        return 1;
    }
}