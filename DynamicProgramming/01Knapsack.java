import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] val = new int[n];
        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int amt = sc.nextInt();
        int[][] dp=new int[arr.length+1][amt+1];
        for(int[] i:dp)Arrays.fill(i,-1);
        System.out.println(knprec(arr,val,amt,arr.length,dp));
    }
    public static int knprec(int[] wt,int[] pt,int w,int n,int[][] dp){
        if(n==0||w==0)return 0;

        if(dp[n][w]!=-1)return dp[n][w];

        if(wt[n-1]>w){
            return dp[n][w]=knprec(wt,pt,w,n-1,dp);
        }

        else{
            return dp[n][w]=Math.max(pt[n-1]+knprec(wt,pt,w-wt[n-1],n-1,dp),knprec(wt,pt,w,n-1,dp));
        }
    }
}