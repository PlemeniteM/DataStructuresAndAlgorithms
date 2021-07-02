class Solution {
    public ListNode middleNode(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode slow=head,fast=head;
        //In odd nodes mid is one and in even nodes mid are two
        //This is in case of even nodes to get second
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //This is in case of even nodes to get first
        // while(fast.next!=null&&fast.next.next!=null){
        //     slow=slow.next;
        //     fast=fast.next.next;
        // }
        return slow;
    }
}