import java.io.*;
import java.util.*;

public class Main {
   

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());
      int[][] pair=new int[k][2];
      for(int i=0;i<k;i++){
          String[] temp=br.readLine().split(" ");
          pair[i][0]=Integer.valueOf(temp[0]);
          pair[i][1]=Integer.valueOf(temp[1]);
      }
      List<Integer>[] graph=new ArrayList[n];
      for(int i=0;i<n;i++){
          graph[i]=new ArrayList<>();
      }
      for(int[] edge:pair){
          graph[edge[0]].add(edge[1]);
          graph[edge[1]].add(edge[0]);
      }
      boolean[] visited=new boolean[n];
      ArrayList<ArrayList<Integer>> al=new ArrayList<>();
      for(int i=0;i<n;i++){
          if(visited[i]!=true){
              ArrayList<Integer> temp=new ArrayList<>();
              getC(graph,i,visited,temp);
              al.add(temp);
          }
      }
      
      int sub=0;
      for(int i=0;i<al.size()-1;i++){
          for(int j=i+1;j<al.size();j++){
              int s1=al.get(i).size();
              int s2=al.get(j).size();
              sub+=(s1*s2);
          }
         
      }
      System.out.println(sub);
      
   }
   public static void getC(List<Integer>[] graph,int src,boolean[] visited,ArrayList<Integer> path){
       visited[src]=true;
       path.add(src);
       for(int v:graph[src]){
           if(visited[v]!=true){
               getC(graph,v,visited,path);
           }
       }
   }

}