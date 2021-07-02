class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)return head;
//         Iterative T.C:O(n) S.C:O(1);
//         ListNode prev=null,curr=head;
//         while(curr!=null){
//             ListNode temp=curr.next;
            
//             curr.next=prev;
//             prev=curr;
//             curr=temp;
//         }
        // return prev;
        return recursive(head);
    }
    //Recursive T.C:O(n) S.C:O(n) {stack space}
    public ListNode recursive(ListNode head){
        if(head==null||head.next==null)return head;
        ListNode temp=recursive(head.next);
        head.next.next=head;
        head.next=null;
        return temp;
    }
}