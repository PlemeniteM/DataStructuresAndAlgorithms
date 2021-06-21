class Solution {
    
    class Edge{
        int i;
        int j;
        int dep;
        Edge(int i,int j,int dep){
            this.i=i;
            this.j=j;
            this.dep=dep;
        }
    }
    
    public int swimInWater(int[][] grid) {
        
        PriorityQueue<Edge> pt=new PriorityQueue<>((a,b)->a.dep-b.dep);
        pt.add(new Edge(0,0,grid[0][0]));
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        
        int[][] dirs={{0,1},{1,0},{0,-1},{-1,0}};
        int ans=Integer.MIN_VALUE;
        
        while(!pt.isEmpty()){
            Edge temp=pt.remove();
            if(visited[temp.i][temp.j])continue;
            ans=Math.max(ans,temp.dep);
            if(temp.i==grid.length-1&&temp.j==grid[0].length-1){
               break;
                
            }
            visited[temp.i][temp.j]=true;
            
            for(int[] dir:dirs){
                int x=dir[0];
                int y=dir[1];
                int newx=temp.i+x;
                int newy=temp.j+y;
                if(newx<0||newy<0||newx>=grid.length||newy>=grid[0].length)continue;
                if(!visited[newx][newy]){
                    int dist=grid[newx][newy];
                    // dist+=grid[newx][newy]-grid[temp.i][temp.j]>0?grid[newx][newy]-grid[temp.i][temp.j]:0;
                    pt.add(new Edge(newx,newy,dist));
                }
            }
            
        }
        return ans;
        
    }
}