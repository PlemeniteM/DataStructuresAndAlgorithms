class Solution{
	public static int max(Node node){
      if(node==null)return Integer.MIN_VALUE;
      int max=max(node.right);
      return Math.max(max,node.data);
  }
   
  public static Node remove(Node node, int data) {
    if(node==null)return null;

    if(node.data==data){
        if(node.left==null&&node.right==null){
            return null;
        }
        else if(node.left!=null&&node.right!=null){
            int temp=max(node.left);
            node.data=temp;
            node.left=remove(node.left,temp);
            return node;
        }
        else{
        	return node.left==null?node.right:node.left;
        }
    }

    else if(node.data>data){
        node.left=remove(node.left,data);
    }

    else if(node.data<data){
        node.right=remove(node.right,data);
    }
    
    return node;
  }

}