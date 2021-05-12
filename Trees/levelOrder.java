class Solution{

	public void levelOrder(Node node){
		if(node==null)return;
        Queue<Node> qt=new ArrayDeque<>();
        Queue<Node> ct=new ArrayDeque<>();
        qt.add(node);
        while(qt.size()>0){
           Node top=qt.remove();
           System.out.print(top.data+" ");
           if(top.left!=null){
               ct.add(top.left);
           }
           if(top.right!=null){
               ct.add(top.right);
           }
           if(qt.size()==0){
               qt=ct;
               ct=new ArrayDeque<>();
               System.out.println();
           }
        }
	}
}