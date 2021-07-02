class Solution {
    public ListNode reverse(ListNode head){
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
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null)return true;
        //Get mid of list
        ListNode slow=head,fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        //reverse right half of list
        ListNode nHead=reverse(slow.next);
        slow.next=null;

        ListNode start=head;
        //start comparing the two halves
        while(start!=null&&nHead!=null){
            if(start.val!=nHead.val){
                return false;
            }
            start=start.next;
            nHead=nHead.next;
        }
        return true;
    }
}