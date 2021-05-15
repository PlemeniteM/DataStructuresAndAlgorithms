import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner sc=new Scanner(System.in);
    int n1=sc.nextInt();
    int [] arr=new int[n1];
    
    for(int i=0;i<arr.length;i++){
        arr[i]=sc.nextInt();
    }
    int n2=sc.nextInt();
    int [] a2=new int[n2];
    
    for(int i=0;i<a2.length;i++){
        a2[i]=sc.nextInt();
    }
   
   HashMap<Integer,Integer> ht=new HashMap<>();
   
   for(int i:arr){
       ht.put(i,1);
   }
   for(int i:a2){
       if(ht.containsKey(i)){
           System.out.println(i);
           ht.remove(i);
       }
   }
   
 }

}