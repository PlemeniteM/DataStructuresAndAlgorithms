class Solution {
    
    //Segregate List in odd and even indices
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode second=head.next;
        ListNode e=head,o=head.next;
        while(o!=null&&o.next!=null){
            e.next=o.next;
            e=e.next;
            o.next=e.next;
            o=o.next;
        }
        e.next=second;
        return head;
    }
    
    //Segregate List on odd and even values
     public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode odd=new ListNode(0);
        ListNode even=new ListNode(0);
        ListNode o=odd,e=even,l=head;
        while(l!=null){
            if(l.val%2==0){
                e.next=l;
                e=e.next;
            }
            else{
                o.next=l;
                o=o.next;
            }
            l=l.next;
        }
        e.next=odd.next;
        o.next=null;
        return even.next;
    }

}