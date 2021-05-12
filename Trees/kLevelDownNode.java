class Solution{
  public static void printKLevelsDownRecusrive(Node node,int k){
      if(node==null||k<0)return;
      if(k==0){
          System.out.println(node.data);
      }
      printKLevelsDownRecusrive(node.left,k-1);
      printKLevelsDownRecusrive(node.right,k-1);
  }
  
  public static void printKLevelsDownIterative(Node node, int k){
        if(node==null)return;
        Queue<Node> qt=new ArrayDeque<>();
        qt.add(node);
        int level=0;
        while(qt.size()>0){
            int count=qt.size();
            for(int i=0;i<count;i++){
                node=qt.remove();
                if(level==k){
                    System.out.println(node.data);
                }
                if(node.left!=null){
                    qt.add(node.left);
                }
                if(node.right!=null){
                    qt.add(node.right);
                }
            }
            level++;
        }
  }
}