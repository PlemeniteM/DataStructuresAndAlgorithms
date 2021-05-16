class Solution{
	public ListNode mergeKSortedLists(ListNode[] lists){
		//Time Complexity= O(nlogk)
        if (lists == null) return null;
        if (lists.length == 0) return null;

		Queue<ListNode> qt=new PriorityQueue<>((a,b) -> a.val - b.val);
		for(ListNode l:lists){
			if(l!=null){
				qt.add(l);
			}
		}
		ListNode head=new ListNode(0);
		ListNode dummy=head;
		while(qt.size()>0){
			ListNode node=qt.remove();
			dummy.next=node;
			dummy=node;
			if(node.next!=null){
				qt.add(node.next);
			}
		}

		return head.next;
	}
}