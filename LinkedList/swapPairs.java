class Solution {

    ListNode th=null,tt=null;

    public void addFirst(ListNode head){
        if(th==null){
            th=head;
            tt=head;
        }
        else{
            head.next=th;
            th=head;
        }
    }
    
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)return head;
        int size=0;
        ListNode t=head;
        while(t!=null){
            t=t.next;
            size++;
        }
        ListNode oh=null,ot=null,curr=head;
        while(size>=2){
            int temp=2;
            while(temp-->0){
                ListNode forw=curr.next;
                curr.next=null;
                addFirst(curr);
                curr=forw;
            }
            if(oh==null){
                oh=th;
                ot=tt;
            }
            else{
                ot.next=th;
                ot=tt;
                
            }
            th=null;
            tt=null;
            size-=2;
        }
        ot.next=curr;
        return oh;
    }
}