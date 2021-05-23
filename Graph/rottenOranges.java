class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null||grid.length==0)return 0;
        
        Queue<int[]> qt=new ArrayDeque<>();
        
        int fresh=0;
        
        //count all fresh oranges and all rotten oranges to queue
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    qt.add(new int[]{i,j});
                }
                if(grid[i][j]==1)fresh++;
            }
        }

        //if all oranges are alread rotten return 0;
        if(fresh==0)return 0;
        
        int time=0;
        int[][]  dirs={{0,1},{0,-1},{1,0},{-1,0}};
        while(!qt.isEmpty()){
            int count=qt.size();

            //time only need to increase once beacuse all 4 directions can happen in 1 unit of time
            ++time;
            for(int i=0;i<count;i++){
                int[] orange=qt.remove();
                for(int[] dir:dirs){
                    int row=orange[0]+dir[0];
                    int col=orange[1]+dir[1];
                    
                    //checking if jump is out of bounds or the orange is already rotten or there is an empty space
                    if(row<0||col<0||row>grid.length-1||col>grid[0].length-1||grid[row][col]==0||grid[row][col]==2)continue;
                    
                    grid[row][col]=2;
                    
                    qt.add(new int[]{row,col});

                    fresh--;
                }
            }
        }

        
        return fresh==0?time-1:-1;
    }
}