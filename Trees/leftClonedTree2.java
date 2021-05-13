class Solution{
     
       public static Node transBackFromLeftClonedTree(Node node){
          if(node==null)return null;
          node.left=transBackFromLeftClonedTree(node.left.left);
          node.right=transBackFromLeftClonedTree(node.right);
     
          return node;
        }

}