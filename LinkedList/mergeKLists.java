class Solution {
    //Time Complexity O(NKlogK)
    private ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if(l1==null||l2==null)return l1==null?l2:l1;
        ListNode dummy=new ListNode(0);
        ListNode c1=l1,c2=l2,prev=dummy;
        while(c1!=null&&c2!=null){
            if(c1.val>c2.val){
                prev.next=c2;
                c2=c2.next;
            }
            else{
                prev.next=c1;
                c1=c1.next;
            }
            prev=prev.next;
        }
        prev.next=c2==null?c1:c2;
        return dummy.next;
    }
    private ListNode mergeLists(ListNode[] lists,int st,int en){
        if(st>en)return null;
        if(st==en)return lists[st];
        int mid=(st+en)/2;
        ListNode l1=mergeLists(lists,st,mid);
        ListNode l2=mergeLists(lists,mid+1,en);
        return mergeTwoLists(l1,l2);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)return null;
        return mergeLists(lists,0,lists.length-1);
    }
}