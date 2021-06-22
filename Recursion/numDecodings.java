class Solution {
    
    public int numDecodings(String s) {
        if(s.length()==0)return 1;
        if(s.length()==1){
            if(s.charAt(0)=='0')return 0;
            return 1;
        }
        int[] dp=new int[s.length()];
        char c=s.charAt(s.length()-1);

        if(c=='0')dp[dp.length-1]=0;
        else dp[dp.length-1]=1;

        for(int i=dp.length-2;i>=0;i--){
            char t=s.charAt(i);
            if(t=='0')dp[i]=0;
            else if(i==dp.length-2){
                dp[i]=dp[i+1];
                if(Integer.valueOf(s.substring(i,i+2))<=26)dp[i]+=1;
            }
            else{
                dp[i]=dp[i+1];
                if(Integer.valueOf(s.substring(i,i+2))<=26)dp[i]+=dp[i+2];
            } 
           
        }
        return dp[0];
    }

}