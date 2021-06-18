class Solution {
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks.length<4)return false;
        long sum=0;
        Arrays.sort(matchsticks);

        //Reversing the array
        for(int i=0;i<matchsticks.length/2;i++){
            int temp=matchsticks[i];
            matchsticks[i]=matchsticks[matchsticks.length-1-i];
            matchsticks[matchsticks.length-1-i]=temp;
            
        }
        for(int i:matchsticks)sum+=i;
        if(sum%4!=0)return false;
        return helper(0,0,0,0,matchsticks,0,sum/4);
    }
    public boolean helper(long a,long b,long c,long d,int[] arr,int i,long len){
        if(a>len||b>len||c>len||d>len)return false;
        if(i==arr.length){
            return a==b&&b==c&&c==d;
            
        }
        long side=arr[i];
        
        return helper(a+side,b,c,d,arr,i+1,len)||helper(a,b+side,c,d,arr,i+1,len)||helper(a,b,c+side,d,arr,i+1,len)||helper(a,b,c,d+side,arr,i+1,len);
    }
}