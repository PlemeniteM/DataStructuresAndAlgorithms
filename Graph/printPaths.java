class Solution{
	public static void printPaths(ArrayList<Edge>[] graph,int src,int dest,boolean[] visited,String path){
       if(src==dest){
           System.out.println(path+src);
           return ;
       }
       visited[src]=true;
       path+=src;
       
       for(Edge edge:graph[src]){
           if(visited[edge.nbr]!=true){
               printPaths(graph,edge.nbr,dest,visited,path);
           }
       }
       
       visited[src]=false;
       
   }
}