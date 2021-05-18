class Solution {
   
    public int makeConnected(int n, int[][] connections) {
        //minimum edges required to make all n nodes connected is n-1;
        if(connections.length<n-1)return -1;
        

        List<Integer>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }

        for(int[] edge:connections){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        //Goal is to get number of connected components in the graph
        boolean[] visited=new boolean[n];
        int cc=0;
        for(int i=0;i<n;i++){
               if(visited[i]!=true)
                   cc+=getComp(graph,i,visited);
             
        }
        
        return cc-1;
    }
    
    public int getComp(List<Integer>[] graph,int src,boolean[] visited){
        visited[src]=true;
      
        for(int v:graph[src]){
            
                    if(visited[v]!=true)
                    getComp(graph,v,visited);
                
            }
        return 1;
        
    }
}