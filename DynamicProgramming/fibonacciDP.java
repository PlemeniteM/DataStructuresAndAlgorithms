import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    
    int[] dp=new int[n];
    dp[0]=1;
    dp[1]=1;
    for(int i=2;i<n;i++){
        dp[i]=dp[i-1]+dp[i-2];
    }
    
    System.out.println(dp[n-1]);
 }

}