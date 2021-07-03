import java.util.*;

class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    private static ListNode mergeTwo(ListNode l1,ListNode l2){
        if(l1==null||l2==null)return l1==null?l2:l1;
        ListNode dummy=new ListNode(0);
        ListNode prev=dummy,c1=l1,c2=l2;
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
        prev.next=c1!=null?c1:c2;
        return dummy.next;
    }
    private static ListNode getMid(ListNode head){
        if(head==null||head.next==null)return head;
        ListNode slow=head,fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static ListNode mergeSort(ListNode head) {
       if(head==null||head.next==null)return head;
        ListNode mid=getMid(head);
        ListNode l2=mergeSort(mid.next);
        mid.next=null;
        ListNode l1=mergeSort(head);
        return mergeTwo(l1,l2);
    }
    public static ListNode createList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        ListNode h1 = createList(n);

        ListNode head = mergeSort(h1);
        printList(head);
    }
}