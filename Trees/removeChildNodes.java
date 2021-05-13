class Solution{
       public static Node removeLeaves(Node node){
          if(node==null)return null;
          if(node.left==null&&node.right==null)return null;
    
          Node left=removeLeaves(node.left);
          node.left=left;
          node.right=removeLeaves(node.right);
          return node;
       }

}