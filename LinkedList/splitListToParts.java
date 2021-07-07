class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        
        int size=0;
        ListNode tp=head;
        while(tp!=null){
            tp=tp.next;
            size++;
        }
        ListNode[] arr=new ListNode[k];
        if(size>k){
            int count=size/k;
            int first=size%k;
            ListNode temp=head,end=temp;
            int i=0;
            System.out.println(first);
            while(temp!=null){
                int ss=first>0?count+1:count;
                first--;
                ListNode e=temp;
                while(ss-->1){
                    e=e.next;
                }
                ListNode t2=e.next;
                e.next=null;
                arr[i]=temp;
                temp=t2;
                i++;
            }
            return arr;
        }
        else{
            ListNode curr=head;
            int i=0;
            while(curr!=null){
                arr[i]=new ListNode(curr.val,null);
                curr=curr.next;
                i++;
            }
            while(i<k){
                arr[i]=null;
                i++;
            }
            return arr;
            
        }
        
    }
}