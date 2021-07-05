class Solution {
    //Time Complexity O(2n) Space Complexity O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)return head;
        int size=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            size++;
        }
        if(size==n)return head.next;
        ListNode prev=null,curr=head;
        int idx=size-n;
        while(idx>0){
            prev=curr;
            curr=curr.next;
            idx--;
        }
        prev.next=curr.next;
        curr.next=null;
        return head;
        
    }
    //Time Complexiyt O(n)  Space Complexity O(1);
     public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode slow=dummy,fast=dummy;
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return dummy.next;
    }
}