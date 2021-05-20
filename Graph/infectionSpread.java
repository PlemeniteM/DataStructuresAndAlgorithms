import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
   static class Pair{
       int v;
       int level;
       Pair(int v,int level){
           this.v=v;
           this.level=level;
       }
   }
   public static int soi(ArrayList<Edge>[] graph,int src,int t,boolean[] visited){
       Queue<Pair> qt=new ArrayDeque<>();
       int count=0;
       qt.add(new Pair(src,1));
       while(qt.size()>0){
           Pair rem=qt.remove();
           if(visited[rem.v]==true){
               continue;
           }
           visited[rem.v]=true;
           if(rem.level>t){
               break;
           }
           count++;
            for(Edge e:graph[rem.v]){
              if(visited[e.nbr]!=true){
                  qt.add(new Pair(e.nbr,rem.level+1));
              }
          }
       }
       return count;
   }
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());
      int t = Integer.parseInt(br.readLine());
      boolean[] visited=new boolean[vtces];
     
      System.out.println(soi(graph,src,t,visited));
      
   }

}