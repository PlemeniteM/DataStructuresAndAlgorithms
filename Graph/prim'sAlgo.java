import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }
  static  class Pair implements Comparable<Pair>{
      int v;
      int wt;
      int aq;
      Pair(int v,int wt,int aq){
          this.v=v;
          this.wt=wt;
          this.aq=aq;
      }
      public int compareTo(Pair o2){
          return this.wt-o2.wt;
      }
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
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }
      PriorityQueue<Pair> pq=new PriorityQueue<>();
      pq.add(new Pair(0,0,-1));
      boolean[] visited=new boolean[vtces];
      while(pq.size()>0){
          Pair rem=pq.remove();
          if(visited[rem.v])continue;
          visited[rem.v]=true;
          if(rem.aq!=-1){
              System.out.println("["+rem.v+"-"+rem.aq+"@"+rem.wt+"]");
          }
          for(Edge e:graph[rem.v]){
              if(!visited[e.nbr]){
                  pq.add(new Pair(e.nbr,e.wt,rem.v));
              }
          }
      }
      
   }

}