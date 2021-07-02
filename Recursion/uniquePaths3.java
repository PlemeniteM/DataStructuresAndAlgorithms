class Solution {
    public int uniquePathsIII(int[][] grid) {
       int sx=0,sy=0;
       int x=0,y=0;
       int count=0;
       for(int i=0;i<grid.length;i++){
           for(int j=0;j<grid[0].length;j++){
               if(grid[i][j]==1){
                   sx=i;
                   sy=j;
               }
               if(grid[i][j]==2){
                   x=i;
                   y=j;
               }
               if(grid[i][j]==0)count++;
           }
       }
      return allPaths(grid,sx,sy,count,x,y);
    }
    public int allPaths(int[][] grid,int i,int j,int count,int dx,int dy){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]==-1||grid[i][j]==3)return 0;
        if(i==dx&&j==dy){
            
            return count==0?1:0;
        }
        int temp=grid[i][j];
        if(temp==0)count--;
        grid[i][j]=3;
        
        int p1=allPaths(grid,i-1,j,count,dx,dy);
        int p2=allPaths(grid,i+1,j,count,dx,dy);
        int p3=allPaths(grid,i,j-1,count,dx,dy);
        int p4=allPaths(grid,i,j+1,count,dx,dy);
        grid[i][j]=temp;
        count++;
        return p1+p2+p3+p4;
    }
}