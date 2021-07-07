class Solution {
    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer> st=new Stack<>();
        int size=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            size++;
        }
        ListNode prev=null,curr=head;
        while(curr!=null){
            ListNode t=curr.next;
            curr.next=prev;
            prev=curr;
            curr=t;
        }
        
        int[] ngr=new int[size];
        ngr[size-1]=0;
        st.push(prev.val);
        
        prev=prev.next;
        for(int i=size-2;i>=0;i--){
            while(st.size()>0&&prev.val>=st.peek())st.pop();
            if(st.size()==0){
                ngr[i]=0;
            }
            else ngr[i]=st.peek();
            st.push(prev.val);
            prev=prev.next;
        }
        return ngr;
    }
}