class Solution {
    int r=0;
    int c=0;
    int max=0;
    public int getMaximumGold(int[][] grid) {
        r=grid.length;
        c=grid[0].length;
        for(int i=0;i<grid.length;i++){
           for(int j=0;j<c;j++){
             if(grid[i][j]!=0){
               ans(grid,i,j,0);
             }
           }
        }
        
        
        return max;
    }
    public void ans(int[][] gri,int s,int v,int cugo){
        if(s<0||v<0||s>=r||v>=c||gri[s][v]==0){
            max=Math.max(cugo,max);
            return ;
        }
        
        int val=gri[s][v];
        gri[s][v]=0;
        ans(gri,s-1,v,cugo+val);
        ans(gri,s,v-1,cugo+val);
        ans(gri,s+1,v,cugo+val);
        ans(gri,s,v+1,cugo+val);
        gri[s][v]=val;
        
    }
}