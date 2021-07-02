class Solution {
    private ListNode reverse(ListNode head){
        if(head==null||head.next==null)return head;
        ListNode prev=null,curr=head;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        if(head==null||head.next==null)return ;
        ListNode slow=head,fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode sec=reverse(slow.next);
        slow.next=null;
        ListNode start=head;
        while(start!=null&&sec!=null){
            ListNode c1=start.next;
            ListNode c2=sec.next;
            start.next=sec;
            sec.next=c1;
            start=c1;
            sec=c2;
        }
            
    }
}