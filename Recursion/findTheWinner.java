 class Solution {
    //Iterative
    public int findTheWinner(int n, int k) {
        int res = 0;
        for (int i = 1; i <= n; ++i)
            res = (res + k) % i;
        return res + 1;
    }
    
    //Recursive
    public int findTheWinner(int n, int k) {
        return helper(n,k)+1;
    }

    public int helper(int n,int k){
        if(n==1)return 0;
        int x=helper(n-1,k);
        return (x+k)%n;
    }
}