class Solution {
    class Pair{
        int v;
        int level;
        Pair(int v,int level){
            this.v=v;
            this.level=level;
        }
    }
    public boolean isBipartite(int[][] arr) {
       
        
        int[] visited=new int[arr.length];
         Arrays.fill(visited,-1);
        for(int i=0;i<arr.length;i++){
            if(visited[i]==-1){
                if(!isBipart(arr,i,visited)){
                    return false;
                }
                
            }
        }
        return true;
    }
    public  boolean isBipart(int[][] graph,int src,int[] visited){
       ArrayDeque<Pair> q=new ArrayDeque<>();
       q.add(new Pair(src,0));
       while(q.size()>0){
           Pair r=q.removeFirst();
           
           if(visited[r.v]!=-1){
               if(r.level!=visited[r.v]){
                   return false;
               }
           }
           else{
               visited[r.v]=r.level;
           }
           for(int e:graph[r.v]){
              
               if(visited[e]==-1){
                   q.add(new Pair(e,r.level+1));
               }
           }
       }
       return true;
   }
}