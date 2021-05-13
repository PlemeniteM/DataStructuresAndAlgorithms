class Solution{
	//For a tree to BST all its subtrees must be a BST
	//And value of root must be greater than max(leftsubtree) and smaller than min(rightsubtree);
	 static class BST{
      boolean isBst;
      int max;
      int min;
  }
  public static BST isBST(Node root){
      if(root==null){
          BST temp=new BST();
          temp.isBst=true;
          temp.max=Integer.MIN_VALUE;
          temp.min=Integer.MAX_VALUE;
          return temp;
      }
      
      BST left=isBST(root.left);
      BST right=isBST(root.right);
      
      BST curr=new BST();
      curr.isBst=(left.isBst&&right.isBst)&&(root.data>left.max&&root.data<right.min);
      curr.max=Math.max(root.data,Math.max(left.max,right.max));
      curr.min=Math.min(root.data,Math.min(left.min,right.min));
      
      return curr;
  }
 
}