class Solution
{

	public int minDiffernce(int arr[], int n) 
	{ 
	        int sum=0;
	        for(int i=0;i<n;i++){
	            sum+=arr[i];
	        }
	    
	        int min=Integer.MAX_VALUE;
	    
	        HashSet<Integer> ht=new HashSet<>();
	        boolean[][] dp=new boolean[arr.length+1][sum+1];
	        for(int i=0;i<dp.length;i++){
	        for(int j=0;j<dp[0].length;j++){
	            if(j==0)dp[i][j]=true;
	            else if(i==0)dp[i][j]=false;
	            else{
	                if(arr[i-1]>j)dp[i][j]=dp[i-1][j];
	                else dp[i][j]=dp[i-1][j]||dp[i-1][j-arr[i-1]];
	            }
	            
	        }
	        
	       }
	       for(int j=0;j<=dp[0].length/2;j++){
	           if(dp[dp.length-1][j])ht.add(j);
	           
	       }
	       
	       for(Integer i:ht){
	           min=Math.min(min,Math.abs(sum-2*i));
	       }
	       
	       
	       return min;
	    
	} 
}
