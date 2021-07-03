class Solution {
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null||l2==null)return l1==null?l2:l1;
        ListNode dummy=new ListNode(0);
        ListNode c1=l1,c2=l2,prev=dummy;
        while(c1!=null&&c2!=null){
            if(c1.val>c2.val){
                prev.next=c2;
                c2=c2.next;
                prev=prev.next;
            }
            else{
                prev.next=c1;
                c1=c1.next;
                prev=prev.next;
            }
        }
        if(c2==null){
            prev.next=c1;
        }
        if(c1==null){
            prev.next=c2;
        }
        return dummy.next;
    }
    //Won't work for large testcases
    // public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    //     if(l1==null||l2==null)return l1==null?l2:l1;
    //     if(l1.val>l2.val)return mergeTwoLists(l2,l1);
    //     l1.next=mergeTwoLists(l1.next,l2);
    //     return l1;
    // }
}