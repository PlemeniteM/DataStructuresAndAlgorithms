class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)return null;
        Node newHead=new Node(head.val);
        Node temp=head.next,curr=newHead;
        HashMap<Node,Node> map=new HashMap<>();
        map.put(head,newHead);
        while(temp!=null){
            Node next=new Node(temp.val);
            curr.next=next;
            curr=curr.next;
            map.put(temp,curr);
            temp=temp.next;
            
            
        }
        curr.next=null;
        
        Node ra1=head;
        while(ra1!=null){
            Node cn=map.get(ra1);
            cn.random=map.get(ra1.random);
            ra1=ra1.next;
        }
        
        return newHead;
        
    }
}