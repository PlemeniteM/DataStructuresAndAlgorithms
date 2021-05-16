import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
           arr[i] = Integer.parseInt(br.readLine());
        }

        int k = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pt=new PriorityQueue<>();

        for(int i=0;i<=k;i++){
            pt.add(arr[i]);
        }
        
        for(int i=k+1;i<n;i++){
            System.out.println(pt.remove());
            pt.add(arr[i]);
        }  
        while(pt.size()>0){
            System.out.println(pt.remove());
        }
      
      
   }

}