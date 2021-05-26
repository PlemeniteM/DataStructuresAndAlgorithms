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
        
        int[][] dp=new int[n+1][amt+1];
        
        
        for(int i=0;i<n+1;i++){
            for(int j=0;j<dp[0].length;j++){
                if(j==0)dp[i][j]=0;
                else if(i==0)dp[i][j]=0;
                else{
                    if(arr[i-1]>j)dp[i][j]=dp[i-1][j];
                    else if(arr[i-1]<=j) dp[i][j]=Math.max(dp[i-1][j],dp[i][j-arr[i-1]]+val[i-1]);
                }
                
            }
        }
        System.out.println(dp[arr.length][amt]);
	    }
	}