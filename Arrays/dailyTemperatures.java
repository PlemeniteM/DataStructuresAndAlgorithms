class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        Stack<Integer> st=new Stack<>();
        st.push(n-1);
        int[] ngr=new int[n];
        ngr[n-1]=0;
        for(int i=n-2;i>=0;i--){
            while(st.size()>0&&temperatures[i]>=temperatures[st.peek()])st.pop();
            if(st.size()==0){
                ngr[i]=0;
            }
            else{
                ngr[i]=st.peek()-i;
            }
            st.push(i);
        }
        return ngr;
    }
}