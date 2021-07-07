class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null)return head;
        int err=-101;//This is the value of last invalid node
        ListNode dummy=new ListNode(0);
        
        ListNode dNode=dummy;
        ListNode prev=head,curr=head.next;
        while(curr!=null){
            if(prev.val==curr.val)err=prev.val;//if adjacent nodes are similar then update the err with prev
            if(prev.val!=curr.val&&err!=prev.val){//If they are unequal then check if prev node had any previous dupliactes by comparing with err
                   err=prev.val;
                   dNode.next=prev;
                   dNode=dNode.next;
            }
            prev=prev.next;
            curr=curr.next;
        }
        if(prev.val!=err)
           dNode.next=prev;
        else dNode.next=null;
        return dummy.next;
    }
}